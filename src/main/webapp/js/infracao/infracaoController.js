App.controller('InfracaoCtrl', function($scope, InfracaoService, $route,$routeParams,$location,EnvioService){
	$scope.infracao = [];
	$scope.infracaoEditar = {};
	$scope.infracaoCriar = {};

	$scope.notFound = false;
	InfracaoService.list().then(function(data){
		$scope.infracao = data.data;
		if(data.data.length == 0){
			$scope.notFound = true;
		}
	},function(data){
		console.log("data", data);
	});
	$scope.infracaoEditar = EnvioService.getParametro();
	$scope.infracaoCriar = EnvioService.getParametro();
	
	$scope.deletar = function(item){
		InfracaoService.delete(item).then(function(data){
			console.log(data);
			$route.reload();
		});	
	}
	
	$scope.editar = function(item){
		$scope.infracaoEditar = {};
		EnvioService.addParametro(item);
		$location.path('/editarInfracao');
	}

	$scope.atualizar = function(item){
		InfracaoService.update(item, item.idInfracao).then(function(data){
				$location.path('/infracao');
				$route.reload();
			});
	}
	
	$scope.criacao = function(){
		$scope.infracaoCriar = {};
		EnvioService.addParametro($scope.infracaoCriar);
		$route.reload();
		$location.path('/criarInfracao');
	}
	
	$scope.criar = function(item){
		InfracaoService.create(item).then(function(data){
			$location.path('/infracao');
			$route.reload();
		});
	}
	
});