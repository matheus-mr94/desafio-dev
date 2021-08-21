package br.com.bycoders.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bycoders.dtos.UsuarioDTO;
import br.com.bycoders.dtos.UsuarioDetalheDTO;
import br.com.bycoders.mappers.UsuarioMapper;
import br.com.bycoders.models.Usuario;
import br.com.bycoders.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioMapper usuarioMapper;

	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + "não encontrado"));
	}

	public Usuario create(UsuarioDTO dto) {
		Usuario user = usuarioMapper.toEntity(dto);
		return usuarioRepository.save(user);
	}

	public List<UsuarioDetalheDTO> getAll() {
		return usuarioRepository.findAll().stream().map(usuarioMapper::toShow).collect(Collectors.toList());
	}

	public UsuarioDetalheDTO getById(Long id) {
		return usuarioRepository.findById(id).map(usuarioMapper::toShow)
				.orElseThrow(() -> new EntityNotFoundException(id + "não encontrado"));
	}

	public UsuarioDTO update(Long id, UsuarioDTO dto) {
		Usuario user = this.findById(id);
		user.setNome(dto.getNome());
		user.setEmail(dto.getEmail());
		user.setSenha(dto.getSenha());
		return usuarioMapper.toDTO(usuarioRepository.save(user));
	}
	
	public String delete(Long id) throws Exception {
		try {
			usuarioRepository.deleteById(id);
			return "Usuário deletado com sucesso";
		}catch(Exception e) {
			throw new Exception("Não foi possível remover o usuário");
		}
	}
}
