//Criacao de controllers
cdsJobs.controller ("indexController", function  ($scope,$location,$route,$http,config){
		
	
	$scope.usuarios=[];
	$scope.usuario={}; //Bind com o form
	$scope.message="";
	$scope.file="";
	
	$scope.salvarUsuario= function (){
		
		if ($scope.frmUsuario.$valid){
			$http({method:'POST', url:config.baseUrl + '/cadastrarUsuario/',data:$scope.usuario})
			.then(function (response){
				$scope.frmUsuario.$setPristine(true);
				$scope.message ="Dados Cadastrados com Sucesso!"				
			} , function (response){
				$scope.message =response.data.message;
			});
		}else {
			$scope.message = "Dados inválidos!";
		}
		
		
	}
	
	$scope.login = function (){
		if ($scope.frmLogin.$valid){
			$http({method:'POST', url:config.baseUrl + '/login/',data:$scope.usuario})
			.then(function (response){
				$scope.frmLogin.$setPristine(true);
					$scope.usuario = response.data;
					window.sessionStorage.setItem('usuario', JSON.stringify($scope.usuario));
					location.href=("/jobs/detalhe.html");
			} , function (response){
				$scope.message =response.data.message;
			});
		}else {
			$scope.message = "Usuário ou senha inválida!";
		}
		
		
	}
	
});

