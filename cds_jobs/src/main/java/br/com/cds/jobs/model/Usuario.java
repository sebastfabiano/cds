package br.com.cds.jobs.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "email"},name="usuario_ctn"))
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1734490766448796033L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUsuario;
	@NotNull
	@Size(min = 4, max = 100)
	private String email;
	@NotNull
	@Size(min = 4, max = 10)
	private String senha;
	@NotNull
	@Size(min = 4, max = 80)
	private String nome;
	private String endereco;
	private String telefone;
	private String celular;

	@JsonProperty("documentos")
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<DocumentoUsuario> documentos;
	

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Usuario(String email, String senha, String nome, String endereco, String telefone, String celular) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.celular = celular;
	}



	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public List<DocumentoUsuario> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<DocumentoUsuario> documentos) {
		this.documentos = documentos;
	}


}
