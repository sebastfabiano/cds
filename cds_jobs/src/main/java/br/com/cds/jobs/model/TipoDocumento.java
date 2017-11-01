package br.com.cds.jobs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_documento" )
public class TipoDocumento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6532375535681742599L;
	@Id
	@Column(name = "cod_tipo")
	private Integer codTipo;
	
	private String descricao;

	public Integer getCodTipo() {
		return codTipo;
	}

	public void setCodTipo(Integer codTipo) {
		this.codTipo = codTipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
