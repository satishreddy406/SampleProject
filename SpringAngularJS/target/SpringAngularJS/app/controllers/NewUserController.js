app.controller('newUserController', function($scope, $http) {
	$scope.newUser = function() {
		if ($scope.username != null && $scope.password != null
				&& $scope.cnfpassword != null) {
			var user = {
				"username" : $scope.username,
				"password" : $scope.password
			};
			$http({
				method : "POST",
				url : "../SpringAngularJS/rest/user",
				data : user,
				headers : {
					'Content-Type' : 'application/json'
				}
			}).success(function() {
				$scope.username = "";
				$scope.password = "";
				$scope.cnfpassword = "";

			});
		}
	};
});
