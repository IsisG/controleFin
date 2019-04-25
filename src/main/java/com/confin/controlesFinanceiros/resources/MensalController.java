package com.confin.controlesFinanceiros.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public List<DadosMensais> findAll() {
		return repositorioMensal.findAll();
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "/{nome}")
	public List<DadosMensais> mostrar(@PathVariable String nome) {
		return repositorioMensal.findAllByProjetos_NomeProjetos(nome);		
	};

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, path = "/salvar")
	public DadosMensais salvar(@RequestBody DadosMensais dados) {
		System.out.println(dados);
		DadosProjetos projeto = projetoRepository.findAllById(dados.getProjetos().getId());
		dados.setProjetos(projeto);
		return repositorioMensal.save(dados);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.DELETE, path = "apagar/{id_mensal}")
	public void apagar(@PathVariable(value ="id_mensal") Integer id_mensal) {
		repositorioMensal.deleteById(id_mensal);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT, path = "/atualizar")
	public DadosMensais atualizarProjeto(@RequestBody DadosMensais dados) {
		System.out.println(dados);
		DadosProjetos projeto = projetoRepository.findAllById(dados.getProjetos().getId());
		dados.setProjetos(projeto);
		return repositorioMensal.save(dados);

	}

}
