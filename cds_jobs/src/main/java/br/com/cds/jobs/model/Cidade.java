package br.com.cds.jobs.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the cidade database table.
 * 
 */
@Entity
@NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cidadeId;

	private String nome;

	@ManyToOne
	@JoinColumn(name = "EstadoId")
	private Estado estado;

	public Cidade() {
	}

	public Integer getCidadeId() {
		return this.cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}