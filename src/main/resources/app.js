
var modulo = angular.module("app", []);

modulo.controller("controllerProjeto", function($scope, $http){
	
	var app =$scope;
	app.mensagem ="Teste";
	
/*	app.projeto = [];
	
	var carregarProjetos = function(){
		$http.get("http://localhost:8080/inicio").then(function(data){
			console.log(data);
		});
	};*/
	
	app.salvarProjeto = function(projeto){
		console.log(projeto);
		$http.post("http://localhost:8080/inicio/salvar", projeto).then(function(data){
			console.log(data);
			reload();
		});
	};
	
	app.deletarProjeto = function(projeto){
		$http.delete("http://localhost:8080/inicio/apagar/{id}", projeto).then(function(data){
			
		});
	};
	
	carregarProjetos();
});

modulo.controller("controllerlistarProjeto", function($scope, $http){
	
	var app =$scope;
	
	app.teste="teste2";
		
	app.projetos = [];

	
	var carregarProjetos = function(){
		$http.get("http://localhost:8080/inicio").then(function(data){
			app.projetos = data;
			console.log("listando:" + data);
		});
	};
	
	carregarProjetos();
});