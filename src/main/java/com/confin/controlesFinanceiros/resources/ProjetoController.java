package com.confin.controlesFinanceiros.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.confin.controlesFinanceiros.domain.DadosProjetos;
import com.confin.controlesFinanceiros.repository.ProjetoRepository;

@RestController
@RequestMapping("/inicio")
public class ProjetoController {

	@Autowired
	private ProjetoRepository repositorio;

	@GetMapping
	public Iterable<DadosProjetos> findAll() {
		return repositorio.findAll();
	}

	@GetMapping("/{id}")
	public Optional<DadosProjetos> findOne(@PathVariable(value = "id") Integer id) {
		return repositorio.findById(id);
	}

	@PostMapping("/salvar")
	public DadosProjetos salvar(DadosProjetos dados) {
		System.out.println(dados);
		return repositorio.save(dados);
	}

	@DeleteMapping("apagar/{id}")
	public void apagar(@PathVariable Integer id) {
		repositorio.deleteById(id);
		System.out.println("Apagado com Sucesso!");
	}

	@PutMapping("/atualizar/{id}")
	public DadosProjetos atualizarProjeto(DadosProjetos dados) {
		System.out.println(dados);
		return repositorio.save(dados);

	}

}
