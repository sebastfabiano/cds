package br.com.cds.test;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cds.jobs.model.Usuario;
import br.com.cds.jobs.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UsuarioEndPontTests { 

    final String BASE_PATH = "http://localhost:8080/jobs/";

	@Autowired
	private UsuarioRepository repository;
	
    private RestTemplate restTemplate;
    
    private ObjectMapper MAPPER = new ObjectMapper();
    
    @Before
    public void setUp() throws Exception {
        repository.deleteAll();
        repository.save(new Usuario("uslsdafsadf@lldldld", "1233326", "sadfasdfasdf","iodoodoo","5554555","554555"));        
        restTemplate = new RestTemplate();
    }
	@Test
	public void contextLoads() {
	}
    
    @Test
    public void testListarUsuarios() throws IOException{
    	String response = restTemplate.getForObject(BASE_PATH + "/listarUsuario/", String.class);
        List<Usuario> lista = MAPPER.readValue(response, MAPPER.getTypeFactory().constructCollectionType(List.class, Usuario.class));
        for (Usuario usuario : lista) {
        	Assert.assertEquals(" # ",usuario.getEmail()+" - "+usuario.getNome());
		}
    
    }
}
