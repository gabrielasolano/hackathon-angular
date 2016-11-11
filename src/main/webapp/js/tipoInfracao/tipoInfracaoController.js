App.controller('TipoInfracaoCtrl', function($scope, TipoInfracaoService, $route,$routeParams,$location,EnvioService){
	$scope.tipoInfracao = [];
	$scope.tipoInfracaoEditar = {};
	$scope.tipoInfracaoCriar = {};

	$scope.notFound = false;
	TipoInfracaoService.list().then(function(data){
		$scope.tipoInfracao = data.data;
		if(data.data.length == 0){
			$scope.notFound = true;
		}
	},function(data){
		console.log("data", data);
	});
	$scope.tipoInfracaoEditar = EnvioService.getParametro();
	$scope.tipoInfracaoCriar = EnvioService.getParametro();
	
	$scope.deletar = function(item){
		TipoInfracaoService.delete(item).then(function(data){
			console.log(data);
			$route.reload();
		});	
	}
	
	$scope.editar = function(item){
		$scope.tipoInfracaoEditar = {};
		EnvioService.addParametro(item);
		$location.path('/editarTipoInfracao');
	}

	$scope.atualizar = function(item){
		TipoInfracaoService.update(item, item.idTipoInfracao).then(function(data){
				$location.path('/tipoInfracao');
				$route.reload();
			});
	}
	
	$scope.criacao = function(){
		$scope.tipoInfracaoCriar = {};
		EnvioService.addParametro($scope.tipoInfracaoCriar);
		$route.reload();
		$location.path('/criarTipoInfracao');
		
	}
	
	$scope.criar = function(item){
		TipoInfracaoService.create(item).then(function(data){
			$location.path('/tipoInfracao');
			$route.reload();
		});
	}
	
});