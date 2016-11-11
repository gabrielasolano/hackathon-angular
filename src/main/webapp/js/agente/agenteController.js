App.controller('AgenteCtrl', function($scope, AgenteService, $route,$routeParams,$location,EnvioService){
	$scope.agente = [];
	$scope.agenteEditar = {};
	$scope.agenteCriar = {};

	$scope.notFound = false;
	AgenteService.list().then(function(data){
		$scope.agente = data.data;
		if(data.data.length == 0){
			$scope.notFound = true;
		}
	},function(data){
		console.log("data", data);
	});
	$scope.agenteEditar = EnvioService.getParametro();
	$scope.agenteCriar = EnvioService.getParametro();
	
	$scope.deletar = function(item){
		AgenteService.delete(item).then(function(data){
			console.log(data);
			$route.reload();
		});	
	}
	
	$scope.editar = function(item){
		$scope.agenteEditar = {};
		EnvioService.addParametro(item);
		$location.path('/editarAgente');
	}

	$scope.atualizar = function(item){
		AgenteService.update(item, item.idAgente).then(function(data){
				$location.path('/agente');
				$route.reload();
			});
	}
	
	$scope.criacao = function(){
		$scope.agenteCriar = {};
		EnvioService.addParametro($scope.agenteCriar);
		$route.reload();
		$location.path('/criarAgente');
	}
	
	$scope.criar = function(item){
		AgenteService.create(item).then(function(data){
			$location.path('/agente');
			$route.reload();
		});
	}
	
});