package com.confin.controlesFinanceiros.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.confin.controlesFinanceiros.domain.DadosMensais;
import com.confin.controlesFinanceiros.domain.DadosProjetos;
import com.confin.controlesFinanceiros.repository.MensalRepository;
import com.confin.controlesFinanceiros.repository.ProjetoRepository;

@RestController
@RequestMapping("/mensal")
public class MensalController {

	@Autowired
	private MensalRepository repositorioMensal;

	private ProjetoRepository projetoRepository;

	public MensalController(ProjetoRepository projetoRepository) {
		this.projetoRepository = projetoRepository;
	}

	@GetMapping("/listar")
	public List<DadosMensais> findAll() {
		return repositorioMensal.findAll();
	}

	@GetMapping("/{id_mensal}")
	public Optional<DadosMensais> findOne(@PathVariable(value = "id_mensal") Integer id_mensal) {
		return repositorioMensal.findById(id_mensal);

	}

	@PostMapping("/salvar")
	public DadosMensais salvar(DadosMensais dados) {
		System.out.println(dados);
		DadosProjetos projeto = projetoRepository.findAllById(dados.getProjetos().getId());
		dados.setProjetos(projeto);
		return repositorioMensal.save(dados);
	}

	@DeleteMapping("apagar/{id_mensal}")
	public void apagar(@PathVariable Integer id_mensal) {
		repositorioMensal.deleteById(id_mensal);
	}

	@PutMapping("/atualizar/{id_mensal}")
	public DadosMensais atualizarProjeto(DadosMensais dados) {
		System.out.println(dados);
		DadosProjetos projeto = projetoRepository.findAllById(dados.getProjetos().getId());
		dados.setProjetos(projeto);
		return repositorioMensal.save(dados);

	}

}
