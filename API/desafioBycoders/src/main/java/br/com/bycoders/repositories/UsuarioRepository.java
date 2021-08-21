package br.com.bycoders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bycoders.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
