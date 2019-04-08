package com.confin.controlesFinanceiros.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.confin.controlesFinanceiros.domain.DadosProjetos;

@Repository
public interface ProjetoRepository extends CrudRepository<DadosProjetos, Integer>{
	

}
