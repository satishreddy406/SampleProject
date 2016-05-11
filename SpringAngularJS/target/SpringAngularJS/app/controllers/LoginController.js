app.controller('loginController', function($scope, $window, $http, $location) {
	$scope.login = function() {
		/*
		 * var urlBase = "http://192.168.5.199:8000/SpringAngularJS/rest";
		 */
		if ($scope.username != null && $scope.password != null) {

			$http({
				method : "post",
				url : "../SpringAngularJS/rest/authicate",
				params : {
					username : $scope.username,
					password : $scope.password
				},
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).then(function(res) {
				$scope.username = null;
				$scope.password = null;
				if(res.data == "success")
					$location.path("/success").replace();
				else
					$location.path("/error").replace();


			}, function(res) {
				$location.path("/error").replace();

			});
		}
	};
});