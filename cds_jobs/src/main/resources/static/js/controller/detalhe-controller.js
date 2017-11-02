//Criacao de controllers
cdsJobs.controller ("detalheController", function  ($scope,$location,$route,$http,config){
		
	
	$scope.usuarios=[];
	$scope.usuario={}; //Bind com o form
	$scope.oportunidade=[];
	$scope.oportunidade={}; //Bind com o form
	$scope.ocorrencias=[];
	$scope.ocorrencia={}; 	
	$scope.message="";
	
	$scope.init = function(){                   
        $scope.usuario = JSON.parse(window.sessionStorage.getItem('usuario'));
        //window.sessionStorage.removeItem('usuario');
        if($scope.usuario ==null){
        	location.href=("/jobs/index.html");
        }
    }
    $scope.init();
    
	$scope.sair= function (){
		window.sessionStorage.removeItem('usuario');
		location.href=("/jobs/index.html");
	}
	
	$scope.atualizarUsuario= function (){
		
		if ($scope.frmDetalheUsuario.$valid){
			$http({method:'POST', url:config.baseUrl + '/cadastrarUsuario/',data:$scope.usuario})
			.then(function (response){
				$scope.frmDetalheUsuario.$setPristine(true);
				$scope.message ="Dados Cadastrados com Sucesso!"				
			} , function (response){
				$scope.message =response.data.message;
			});
		}else {
			$scope.message = "Dados inválidos!";
		}
		
		
	}
	
	$scope.login= function (){
		if ($scope.frmLogin.$valid){
			$http({method:'POST', url:config.baseUrl + '/login/',data:$scope.usuario})
			.then(function (response){
				$scope.frmLogin.$setPristine(true);
				window.sessionStorage.setItem('usuario', JSON.stringify($scope.usuario));
                location.href=("/jobs/detalhe.html");
			} , function (response){
				window.alert(response.status);
			});
		}else {
			window.alert("Dados inválidos!");
		}
		
		
	}
	
});

