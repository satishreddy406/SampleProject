/**
 * 
 */
app.controller('customerController', function($http, $log, $scope, $rootScope,
		$route, $location, $filter, $window) {

	$scope.customers = [];

	// $scope.allUsers = function() {
	if ($location.path() == "/customer") {
		$http({
			method : "GET",
			url : "../SpringAngularJS/rest/getAllCustomers",

		}).success(function(data) {
			$scope.customers = data;

		});
	}

	// };

	/*
	 * $scope.editingData = [];
	 * 
	 * for (var i = 0, length = $scope.users.length; i < length; i++) {
	 * $scope.editingData[$scope.users[i].id] = false; }
	 * 
	 * 
	 * $scope.modify = function(user){ $scope.editingData[user.id] = true; };
	 * 
	 * 
	 * $scope.update = function(user){ $scope.editingData[user.id] = false;
	 * 
	 * var user = { "username" : $scope.username, "password" : $scope.password };
	 * 
	 * $http({ method : "PUT", url : "../SpringAngularJS/rest/user", data :
	 * user, headers : { 'Content-Type' : 'application/json' }
	 * }).success(function(data) { $scope.users = data; }); };
	 */

});
