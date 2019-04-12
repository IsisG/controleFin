package com.confin.controlesFinanceiros.resources;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.confin.controlesFinanceiros.domain.DadosProjetos;
import com.confin.controlesFinanceiros.repository.ProjetoRepository;

@RestController
@RequestMapping("/inicio")
public class ProjetoController {

	@Autowired
	private ProjetoRepository repositorio;

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<DadosProjetos> findAll() {
		return repositorio.findAll();
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public Optional<DadosProjetos> findOne(@PathVariable(value = "id") Integer id) {
		return repositorio.findById(id);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, path ="/salvar") 
	public DadosProjetos salvar(@RequestBody DadosProjetos dados) {
		System.out.println(dados);
		return repositorio.save(dados);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.DELETE, path ="/apagar/{id}") 
	public void apagar(@PathVariable Integer id) {
		repositorio.deleteById(id);
		System.out.println("Apagado com Sucesso!");
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT, path ="/atualizar/{id}") 
	public DadosProjetos atualizarProjeto(DadosProjetos dados) {
		System.out.println(dados);
		return repositorio.save(dados);

	}

}
