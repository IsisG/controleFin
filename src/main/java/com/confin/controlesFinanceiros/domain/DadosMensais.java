package com.confin.controlesFinanceiros.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dados_mensais")
public class DadosMensais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_mensal;
	@ManyToOne()
	@JoinColumn(name = "id_projeto")
	private DadosProjetos projetos;
	private float valor_mensal;

	public Integer getId_mensal() {
		return id_mensal;
	}

	public void setId_mensal(Integer id_mensal) {
		this.id_mensal = id_mensal;
	}

	public DadosProjetos getProjetos() {
		return projetos;
	}

	public void setProjetos(DadosProjetos projetos) {
		this.projetos = projetos;
	}

	public float getValor_mensal() {
		return valor_mensal;
	}

	public void setValor_mensal(float valor_mensal) {
		this.valor_mensal = valor_mensal;
	}

	@Override
	public String toString() {
		return "DadosMensais [id_mensal=" + id_mensal + ", projetos=" + projetos + ", valor_mensal=" + valor_mensal
				+ "]";
	}

}
