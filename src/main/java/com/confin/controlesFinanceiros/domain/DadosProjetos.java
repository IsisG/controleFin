package com.confin.controlesFinanceiros.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "dados_projetos")
public class DadosProjetos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToMany(mappedBy = "projetos")
	@JsonIgnore
	private List<DadosMensais> mensais;
	private String nome_projetos;
	private Float valor;
	private int qtd_meses;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<DadosMensais> getMensais() {
		return mensais;
	}

	public void setMensais(List<DadosMensais> mensais) {
		this.mensais = mensais;
	}

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

	@Override
	public String toString() {
		return "DadosProjetos [id=" + id + "]";
	}

}
