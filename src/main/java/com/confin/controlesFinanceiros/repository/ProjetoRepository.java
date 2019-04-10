package com.confin.controlesFinanceiros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.confin.controlesFinanceiros.domain.DadosProjetos;

@Repository
public interface ProjetoRepository extends CrudRepository<DadosProjetos, Integer> {

	DadosProjetos findAllById(Integer id);

}
