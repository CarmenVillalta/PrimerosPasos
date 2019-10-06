var app = angular.module('myApp', ['ngRoute']);

app.config(function($routeProvider){
    $routeProvider
	    .when('/',{
	        templateUrl: '/views/vestimeApp_login.html',
	        controller: 'usuarioAbmController'
	    })
	    .when('/home',{
	        templateUrl: '/views/vestimeApp_home.html',
	        controller: 'prendasAbmController'
	    })
	    .when('/prendas',{
	        templateUrl: '/views/vestimeApp_prendas.html',
	        controller: 'prendasAbmController'
	    })
        .otherwise(
            { redirectTo: '/'}
        );
});
