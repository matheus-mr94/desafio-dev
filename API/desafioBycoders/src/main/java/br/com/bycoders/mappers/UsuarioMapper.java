package br.com.bycoders.mappers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.bycoders.dtos.UsuarioDTO;
import br.com.bycoders.dtos.UsuarioDetalheDTO;
import br.com.bycoders.models.Usuario;

@Component
public class UsuarioMapper {

	public Usuario toEntity(UsuarioDTO dto) {
		Usuario user = new Usuario();
		user.setNome(dto.getNome());
		user.setEmail(dto.getEmail());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaCodificada = encoder.encode(dto.getSenha());
		user.setSenha(senhaCodificada);
		return user;
	}

	public UsuarioDTO toDTO(Usuario user) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setNome(user.getNome());
		dto.setEmail(user.getEmail());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaCodificada = encoder.encode(user.getSenha());
		dto.setSenha(senhaCodificada);
		return dto;
	}

	public UsuarioDetalheDTO toShow(Usuario user) {
		UsuarioDetalheDTO dto = new UsuarioDetalheDTO();
		dto.setNome(user.getNome());
		dto.setEmail(user.getEmail());
		dto.setId(user.getId());
		return dto;
	}
	
}
