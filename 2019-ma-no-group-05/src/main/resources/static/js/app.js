var app = angular.module('vestimeApp', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
	    .when('/home',{
	        templateUrl: '/views/vestimeApp.html',
	        controller: 'vestimeController'
	    })
        .otherwise(
            { redirectTo: '/'}
        );
});