package br.com.cds.jobs.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
/**
 * 
 * @author sebast
 *
 */
@Entity
@Table(name = "oportunidade")
public class Oportunidade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 348005499282186889L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idOportunidade;
	@NotNull
	private String titulo;
	
	@NotNull
	private String descricao;
	
	private String detalhe;
	
	private boolean ativo;
	
	
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
	
	
}
