var app = angular.module('loginApp', [ 'ngRoute' ]);

app.config(function($routeProvider) {

	$routeProvider.when('/', {
		templateUrl : 'app/views/login.html',
		controller : 'loginController'
	}).when('/NewUser', {
		templateUrl : 'app/views/NewUser.html',
		controller : 'newUserController'
	}).when('/allUsers', {
		templateUrl : 'app/views/AllUsers.html',
		controller : 'userController'
	}).when('/success', {
		templateUrl : 'app/views/Success.html',
		controller : 'loginController'
	}).when('/error', {
		templateUrl : 'app/views/Error.html',
		controller : 'loginController'
	});

});