var App = angular.module('App', [
'ngRoute',
'controllers',
'services'
]);

App.config(function($routeProvider){
	$routeProvider
	.when('/',{
		templateUrl: 'views/read.html',
		controller: 'ReadCtrl'
	})
	.when('/agente',{
		templateUrl: 'views/agente/agente.html',
		controller: 'AgenteCtrl'
	})
	
	.when('/criarAgente', {
		templateUrl: 'views/agente/criarAgente.html',
		controller: 'AgenteCtrl'
	})

	.when('/editarAgente', {
		templateUrl: 'views/agente/editarAgente.html',
		controller: 'AgenteCtrl'
	})
	
	.when('/tipoInfracao', {
		templateUrl: 'views/tipoInfracao/tipoInfracao.html',
		controller: 'TipoInfracaoCtrl'
	})
	
	.when('/criarTipoInfracao', {
		templateUrl: 'views/tipoInfracao/criarTipoInfracao.html',
		controller: 'TipoInfracaoCtrl'
	})
	
	.when('/editarTipoInfracao', {
		templateUrl: 'views/tipoInfracao/editarTipoInfracao.html',
		controller: 'TipoInfracaoCtrl'
	})
	
	.when('/localInfracao', {
		templateUrl: 'views/localInfracao/localInfracao.html',
		controller: 'LocalInfracaoCtrl'
	})
	
	.when('/criarLocalInfracao', {
		templateUrl: 'views/localInfracao/criarLocalInfracao.html',
		controller: 'LocalInfracaoCtrl'
	})
	
	.when('/editarLocalInfracao', {
		templateUrl: 'views/localInfracao/editarLocalInfracao.html',
		controller: 'LocalInfracaoCtrl'
	})
	
	.when('/infracao', {
		templateUrl: 'views/infracao/infracao.html',
		controller: 'InfracaoCtrl'
	})
	
	.when('/criarInfracao', {
		templateUrl: 'views/infracao/criarInfracao.html',
		controller: 'InfracaoCtrl'
	})
	
	.when('/editarInfracao', {
		templateUrl: 'views/infracao/LocalInfracao.html',
		controller: 'InfracaoCtrl'
	})
/*	.when('/', {
		templateUrl: 'views/agente/agente.html',
		controller: 'AgenteCtrl'
	})

	.when('/criarAgente', {
		templateUrl: 'views/agente/criarAgente.html',
		controller: 'AgenteCtrl'
	})

	.when('/editarAgente', {
		templateUrl: 'views/agente/editarAgente.html',
		controller: 'AgenteCtrl'
	})*/
});

App.value('API', 'http://localhost:8080/angular-app/service/');