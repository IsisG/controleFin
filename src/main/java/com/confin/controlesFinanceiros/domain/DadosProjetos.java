package com.confin.controlesFinanceiros.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dados_projetos")
public class DadosProjetos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@OneToMany(mappedBy = "projetos")
	private List<DadosMensais> mensais;
	private String nome_projetos;
	private Float valor;
	private int qtd_meses;

//	public DadosProjetos(String nome_projetos, Float valor, int qtd_meses) {
//		this.nome_projetos = nome_projetos;
//		this.valor = valor;
//		this.qtd_meses = qtd_meses;
//	}

	public String getNome_projetos() {
		return nome_projetos;
	}

	public void setNome_projetos(String nome_projetos) {
		this.nome_projetos = nome_projetos;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public int getQtd_meses() {
		return qtd_meses;
	}

	public void setQtd_meses(int qtd_meses) {
		this.qtd_meses = qtd_meses;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	
}
