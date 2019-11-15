var app = angular.module('app',['ngRoute','ngResource']);
    app.config(function($routeProvider){
    	
    	$routeProvider
    	       .when('/registration'{
    	    	   
    	    	   TemplaterUrl:'view/register',
    	    	   controller:'registerController'
    	       }).
    	       
    	        when('/login'{
    	    	   TemplateUrl:'view/register',
    	    	   controller:'loginController'
    	    	   
    	       }).
    	       
    	       otherwise({
    	    	   redirectTo:'/'
    	       });
    });