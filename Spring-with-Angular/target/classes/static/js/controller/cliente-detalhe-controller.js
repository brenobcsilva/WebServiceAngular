appCliente.controller("clientedetalhecontroller",function($scope, $routeParams, $http){
	$http.get("clientes/"+$routeParams.clienteId).then(function(response){
		$scope.cliente=response.data;
	}, function(response){
		console.log(response);
	});
});