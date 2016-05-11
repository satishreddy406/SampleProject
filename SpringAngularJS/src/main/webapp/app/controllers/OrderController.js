app.controller('orderController', function($http, $log, $scope, $rootScope,
		$location, $filter, $window) {
	$scope.customerNames = [];
	$http({
		method : "GET",
		url : "../SpringAngularJS/rest/getAllCustomers",
		headers : {
			'Content-Type' : 'application/json'
		}

	}).success(function(data) {
		$scope.customers = data;
		console.log($scope.customers);
		angular.forEach($scope.customers, function(value, key) {
			if ($scope.customerNames.indexOf(value.customer_name) > -1) {
				// console.log(value.customer_name);
			} else {
				if (value.customer_name != null)
					$scope.customerNames.push(value.customer_name);
			}
		});
	});

	$scope.shipaddress = [ {
		"add" : "India"
	}, {
		"add" : "Nepal"
	}, {
		"add" : "USA"
	}, {
		"add" : "UK"
	}, {
		"add" : "China"
	} ];

	$scope.Lengths = [ {
		"len" : 10
	}, {
		"len" : 30
	}, {
		"len" : 90
	}, {
		"len" : 180
	} ]

	$scope.items = [ {
		"id" : 09999
	}, {
		"id" : 30010
	}, {
		"id" : 8909
	}, {
		"id" : 18990
	} ]

	$scope.saveOrder = function() {
		$http({
			method : "POST",
			url : "https://integration-usealliancecotrial54990.integration.us2.oraclecloud.com/integration/flowapi/rest/ORDER_INSERT/v01/saveOrder1",
			data : $scope.order,
			headers:{
				'Content-Type' : 'application/json',
				'Accept' : 'application/json',
				'Authorization' : 'Basic cmt1bWFyQGVhbGxpYW5jZWNvcnAuY29tOmVBbGxpYW5jZTIwMTYh',
			}

		}).success(function(data) {
			console.log("result==>" + data);
		});
		
		
		
	/*	console.log("Orders==>" + $scope.order);
		$http({
			method : "POST",
			url : "../SpringAngularJS/rest/saveOrder",
			data : $scope.order

		}).success(function(data) {

			console.log("result==>" + data);

		});*/
	};

});
