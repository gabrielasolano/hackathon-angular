App.controller('LocalInfracaoCtrl', function($scope, LocalInfracaoService, $route,$routeParams,$location,EnvioService){
	$scope.localInfracao = [];
	$scope.localInfracaoEditar = {};
	$scope.localInfracaoCriar = {};

	$scope.notFound = false;
	LocalInfracaoService.list().then(function(data){
		$scope.localInfracao = data.data;
		if(data.data.length == 0){
			$scope.notFound = true;
		}
	},function(data){
		console.log("data", data);
	});
	$scope.localInfracaoEditar = EnvioService.getParametro();
	$scope.localInfracaoCriar = EnvioService.getParametro();
	
	$scope.deletar = function(item){
		LocalInfracaoService.delete(item).then(function(data){
			console.log(data);
			$route.reload();
		});	
	}
	
	$scope.editar = function(item){
		$scope.localInfracaoEditar = {};
		EnvioService.addParametro(item);
		$location.path('/editarLocalInfracao');
	}

	$scope.atualizar = function(item){
		LocalInfracaoService.update(item, item.idLocalInfracao).then(function(data){
				$location.path('/localInfracao');
				$route.reload();
			});
	}
	
	$scope.criacao = function(){
		$scope.localInfracaoCriar = {};
		EnvioService.addParametro($scope.localInfracaoCriar);
		$route.reload();
		$location.path('/criarLocalInfracao');
		
	}
	
	$scope.criar = function(item){
		LocalInfracaoService.create(item).then(function(data){
			$location.path('/localInfracao');
			$route.reload();
		});
	}
	
});