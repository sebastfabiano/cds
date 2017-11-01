package br.com.cds.jobs.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "oportunidade_usuario")
public class OportunidadeUsuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3333844668069262337L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idOportunidadeUsuario;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_oportunidade")
	private Oportunidade oportunidade;

	private boolean contratado;
	
	private boolean participando;

	public Long getIdOportunidadeUsuario() {
		return idOportunidadeUsuario;
	}

	public void setIdOportunidadeUsuario(Long idOportunidadeUsuario) {
		this.idOportunidadeUsuario = idOportunidadeUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Oportunidade getOportunidade() {
		return oportunidade;
	}

	public void setOportunidade(Oportunidade oportunidade) {
		this.oportunidade = oportunidade;
	}

	public boolean isParticipando() {
		return participando;
	}

	public void setParticipando(boolean participando) {
		this.participando = participando;
	}
	
	
}

