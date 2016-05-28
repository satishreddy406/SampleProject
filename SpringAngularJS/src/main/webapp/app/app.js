var app = angular.module('loginApp', [ 'ngRoute', 'ngMaterial', 'ngAnimate','ngMessages' ]);


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
	}).when('/', {
		templateUrl : 'app/views/login.html',
		controller : 'loginController'
	})
});
angular.module('app').config(function($mdDateLocaleProvider) {
    $mdDateLocaleProvider.formatDate = function(date) {
       return moment(date).format('YYYY-MM-DD');
    };
});