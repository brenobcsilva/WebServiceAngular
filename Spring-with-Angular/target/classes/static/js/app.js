var appCliente = angular.module("appCliente", [ 'ngRoute' ]);

appCliente.config(function($routeProvider, $locationProvider) {
	$routeProvider.when("/clientes", {
		templateUrl : 'view/cliente.html',
		controller : 'clienteController'
	}).when("/clientes/:clienteId", {
		templateUrl : 'view/cliente-detalhe.html',
		controller : 'clientedetalhecontroller'
	}).when("/cidades", {
		templateUrl : 'view/cidade.html',
		controller : 'cidadeController'
	}).when("/estados", {
		templateUrl : 'view/estado.html',
		controller : 'estadoController'
	}).when("/login", {
		templateUrl : 'view/login.html',
		controller : 'loginController'
	}).otherwise({
		rediretTo : '/'
	});

	$locationProvider.html5Mode(true);
});

appCliente.config(function($httpProvider) {
	$httpProvider.intercerceptors.push("tokenInterceptor");
});