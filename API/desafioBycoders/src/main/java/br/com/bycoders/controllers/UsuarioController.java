package br.com.bycoders.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bycoders.dtos.UsuarioDTO;
import br.com.bycoders.dtos.UsuarioDetalheDTO;
import br.com.bycoders.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody UsuarioDTO dto){
		usuarioService.create(dto);
		return new ResponseEntity<>("Usuário criado com sucesso", HttpStatus.CREATED);
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<UsuarioDetalheDTO>> getAll(){
		return new ResponseEntity<List<UsuarioDetalheDTO>>(usuarioService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDetalheDTO> getById(@PathVariable Long id){
		return new ResponseEntity<UsuarioDetalheDTO>(usuarioService.getById(id),HttpStatus.OK);
	}
	
	@PutMapping("/alterar/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody UsuarioDTO dto){
		usuarioService.update(id, dto);
		return new ResponseEntity<>("Usuário atualizado com sucesso", HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) throws Exception{
		return new ResponseEntity<String>(usuarioService.delete(id),HttpStatus.ACCEPTED);
	}

}
