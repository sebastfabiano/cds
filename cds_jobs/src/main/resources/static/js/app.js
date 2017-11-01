//Criacao do modulo principal da aplicacao
var cdsJobs = angular.module("cdsJobs", [ 'ngRoute' ]);

cdsJobs.config(function($routeProvider, $locationProvider) {

	$routeProvider.when("/", {
		templateUrl : '/jobs/index.html',
		controller : ''
	}).when("index", {
		templateUrl : '/index.html',
		controller : 'usuarioController'
	}).when("detalhe", {
		templateUrl : '/detalhe.html',
		controller : 'usuarioController'
	}).otherwise({
		rediretTo : '/jobs'
	});

	$locationProvider.html5Mode({
		enabled : true,
		requireBase : false
	});

});
