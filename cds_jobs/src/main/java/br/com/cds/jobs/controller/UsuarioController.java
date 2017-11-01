package br.com.cds.jobs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cds.jobs.model.DocumentoUsuario;
import br.com.cds.jobs.model.Usuario;
import br.com.cds.jobs.service.UsuarioService;

/**
 * 
 * @author sebast
 *
 */
@RestController
@RequestMapping
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.POST, value = "/cadastrarUsuario/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) throws Exception {
		System.out.println("Chamou o cadastrarUsuario...");
		return new ResponseEntity<Usuario>(usuarioService.cadastrarUsuario(usuario), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/login/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> recuperarUsuario(@RequestBody Usuario usuario) throws Exception {
		System.out.println("Chamou o cadastrarUsuario...");
		return new ResponseEntity<Usuario>(usuarioService.recuperarUsuario(usuario), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listarUsuario/")
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		System.out.println("Chamou o listarUsuario...");
		return new ResponseEntity<List<Usuario>>(usuarioService.listarUsuarios(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/recuperarUsuario/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> recuperarUsuario(@PathVariable("id") long id) {
		System.out.println("Chamou o recuperarUsuario...");
		Usuario usuario = usuarioService.recuperarUsuario(id);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}


	
	@RequestMapping(method = RequestMethod.POST, value = "/cadastrarDocumento/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DocumentoUsuario> cadastrarDocumento(@RequestBody DocumentoUsuario documento) {
		System.out.println("Chamou o cadastrarDocumento...");
		if (documento.getUsuario() == null && documento.getUsuario().getIdUsuario() == null) {
			return new ResponseEntity<DocumentoUsuario>(usuarioService.cadastrarDocumento(documento),
					HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
		} else {
			documento.setUsuario(usuarioService.recuperarUsuario(documento.getUsuario().getIdUsuario()));
		}
		return new ResponseEntity<DocumentoUsuario>(usuarioService.cadastrarDocumento(documento), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/recuperarDocumento/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DocumentoUsuario> recuperarDocumento(@PathVariable("id") long id) {
		System.out.println("Chamou o recuperarUsuario...");
		DocumentoUsuario documento = usuarioService.recuperarDocumento(id);
		return new ResponseEntity<DocumentoUsuario>(documento, HttpStatus.OK);
	}

}
