package br.com.bycoders.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.bycoders.dtos.LoginRespostaDTO;
import br.com.bycoders.dtos.UsuarioDTO;
import br.com.bycoders.dtos.UsuarioDetalheDTO;
import br.com.bycoders.exceptions.EmailOrPasswordNotValidException;
import br.com.bycoders.mappers.UsuarioMapper;
import br.com.bycoders.models.Usuario;
import br.com.bycoders.repositories.UsuarioRepository;
import br.com.bycoders.security.JWTService;

@Service
public class UsuarioService {
	
	private static final String headerPrefix = "Bearer ";

	@Autowired
	UsuarioMapper usuarioMapper;

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	JWTService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Id número" + id + " não encontrado"));
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
				.orElseThrow(() -> new EntityNotFoundException("Id número" + id + " não encontrado"));
	}

	public UsuarioDTO update(Long id, UsuarioDTO dto) {
		Usuario user = this.findById(id);
		user.setNome(dto.getNome());
		user.setEmail(dto.getEmail());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaCodificada = encoder.encode(user.getSenha());
		user.setSenha(senhaCodificada);
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
	
public LoginRespostaDTO logar(String email, String senha) throws EmailOrPasswordNotValidException {
		
		Authentication autenticacao = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(email, senha, Collections.emptyList()));
		SecurityContextHolder.getContext().setAuthentication(autenticacao);
		String token = headerPrefix + jwtService.gerarToken(autenticacao);
		var usuario = usuarioRepository.findByEmail(email);
		return new LoginRespostaDTO(token, usuario.get());
	}
}
