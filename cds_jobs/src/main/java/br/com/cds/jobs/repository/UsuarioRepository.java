package br.com.cds.jobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.cds.jobs.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
