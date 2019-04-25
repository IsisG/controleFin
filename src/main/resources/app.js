
var modulo = angular.module("app", []);

modulo.controller("controllerProjeto", function($scope, $http){
	
	var app =$scope;
	app.mensagem ="Teste";
	
	app.projetos = {};
	
	app.meses = ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"];
	
	app.mensais = {};
	
	// Projeto
	var carregarProjetos = function(){
		$http.get("http://localhost:8080/inicio").then(function(data){
			app.projetos = data.data;
			console.log(data);
		});
	};
	
	app.salvarProjeto = function(projeto){
		console.log(projeto);
		$http.post("http://localhost:8080/inicio/salvar", projeto).then(function(data){
			console.log(data);
			location.reload();
		
		});
	};
	
	// Mensal
	var carregarMensal = function(){
		$http.get("http://localhost:8080/mensal/listar").then(function(data){
			app.mensais = data;
			console.log(data);
		});
	};
	
	app.salvarMensal = function(mensais){
		$http.post("http://localhost:8080/mensal/salvar", mensais).then(function(data){
			console.log(mensais);
			console.log(data);
			location.reload();
		});
		
	};
	
	carregarProjetos();
	// carregarMensal();
});

modulo.controller("controllerlistarProjeto", function($scope, $http){
	
	var app =$scope;
	
	app.teste="teste2";
		
	app.projetos = [];
	
	app.mensais = {};

	
	var carregarProjetos = function(){
		$http.get("http://localhost:8080/inicio").then(function(data){
			app.projetos = data;
			console.log("listando:" + data);
		});
	};
	
	app.deletarProjeto = function(id){
		$http.delete("http://localhost:8080/inicio/apagar/" + id).then(function(data){
			carregarProjetos();
			
		});
		
	};
	
	app.editarProjeto = function(projetos){
		 app.item = projetos;
		 console.log(app.item);
	};
	
	app.atualizarProjeto= function(projetos){
		$http.put("http://localhost:8080/inicio/atualizar", projetos).then(function(data){		
			console.log(data);
			location.reload();
		});
		
	};
// --------------------------------MENSAL---------------------------------------------------------//
	var carregarMensal = function(){
		$http.get("http://localhost:8080/mensal/listar").then(function(data){
			app.mensais = data;
			console.log(data);
		});
	};
	
	app.atualizarMensal= function(mensais){
		$http.put("http://localhost:8080/mensal/atualizar/", mensais).then(function(data){		
			console.log(data);
		});
		
	};
	
	app.editarMensal = function(mensais){
		 app.itens = mensais;
		 console.log(app.itens);
	};
	
	
	app.deletarMensal = function(id_mensal){
		$http.delete("http://localhost:8080/mensal/apagar/" + id_mensal).then(function(data){
			carregarMensal();
		});
		
	};
	
	
	carregarProjetos();
	carregarMensal();
});


modulo.controller("controllercontroles", function($scope, $http){
	
	var app = $scope;
	
	app.teste ="testando...";
	
	app.lista = {};
	
	app.valores = {};
	app.total = 0;
	app.diferenca = 0;
	
	app.mostrarMensal = function(nome){
		$http.get("http://localhost:8080/mensal/"+ nome).then(function(data){
			app.lista = data.data;
			console.log(data.data);
			app.total = 0;
			app.diferenca = 0;
			for(var i=0; i<app.lista.length; i++){
			app.total += app.lista[i].valor_mensal;
			}
			app.diferenca = app.lista[0].projetos.valor - app.total;
			console.log(app.total, app.diferenca);
			
		});
	};
	
});