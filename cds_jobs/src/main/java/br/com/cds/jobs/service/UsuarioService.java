package br.com.cds.jobs.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.cds.jobs.model.DocumentoUsuario;
import br.com.cds.jobs.model.Usuario;
import br.com.cds.jobs.repository.DocumentoUsuarioRepository;
import br.com.cds.jobs.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRp;

	@Autowired
	DocumentoUsuarioRepository documentoRp;

	public Usuario cadastrarUsuario(Usuario usuario) throws Exception {
		Usuario us = null;
		try {
			usuario.setDataAtualizacao(new Date());
			if(usuario.getIdUsuario()==null || usuario.getIdUsuario().longValue()==0) {
				usuario.setDataCadastro(new Date());
			}
			us = usuarioRp.save(usuario);
			if (usuario.getDocumentos() != null && !usuario.getDocumentos().isEmpty()) {
				for (DocumentoUsuario documentoUsuario : usuario.getDocumentos()) {
					documentoUsuario.setUsuario(us);
					documentoRp.save(documentoUsuario);
				}
			}
		} catch (Exception e) {
			if(e.getCause().toString().contains("ConstraintViolationException")) {
				throw new Exception("Usuário já Cadastrado!");
			}else {
				throw new Exception("Ops! Ocorreu um erro interno!");
			}
		}
		return us;
	}
	
	public Usuario recuperarUsuario(Usuario usuario) throws Exception {
		try {
			usuario = usuarioRp.findAll(Example.of(usuario)).get(0);	
		} catch (Exception e) {
				throw new Exception("Usuário ou senha inválida!");
		}
		return usuario;
	}

	public Usuario recuperarUsuario(Long id) {
		Usuario usuario = usuarioRp.findOne(id);
		usuario.getDocumentos().size();
		return usuario;
	}

	public DocumentoUsuario cadastrarDocumento(DocumentoUsuario documento) {
		return documentoRp.save(documento);
	}

	public DocumentoUsuario recuperarDocumento(Long id) {
		return documentoRp.findOne(id);
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRp.findAll();
	}

}
