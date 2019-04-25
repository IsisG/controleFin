package com.confin.controlesFinanceiros.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.confin.controlesFinanceiros.domain.DadosMensais;

@Repository
public interface MensalRepository extends CrudRepository<DadosMensais, Integer> {

	List<DadosMensais> findAll();
	List<DadosMensais> findAllByProjetos_NomeProjetos(String nome);

}