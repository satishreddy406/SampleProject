app.controller('userController', function($scope, $http) {
	
	$scope.users = [];

	$scope.allUsers = function()
	{

		$http({
			method : "GET",
			url : "../SpringAngularJS/rest/users",
			headers : {
				'Content-Type' : 'application/json'
			}
		}).success(function(data) {
			$scope.users = data;

		});
	};

$scope.editingData = [];
    
    for (var i = 0, length = $scope.users.length; i < length; i++) {
      $scope.editingData[$scope.users[i].id] = false;
    }


    $scope.modify = function(user){
        $scope.editingData[user.id] = true;
    };


    $scope.update = function(user){
        $scope.editingData[user.id] = false;
        
    /*    var user = {
				"username" : $scope.username,
				"password" : $scope.password
			};*/

			$http({
				method : "PUT",
				url : "../SpringAngularJS/rest/user",
				data : user,
				headers : {
					'Content-Type' : 'application/json'
				}
			}).success(function(data) {
				$scope.users = data;
			});
       
    };

});
