app.controller('registerController',function($scope,$http){
	$http.post('localhost:8090/api/student/registration').
	function()
	$scope.tittle = '';
});

app.controller('loginController',function($scope){
	$scope.tittle = '';
});
