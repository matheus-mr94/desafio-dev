package br.com.bycoders.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bycoders.dtos.LojaDTO;
import br.com.bycoders.models.Loja;
import br.com.bycoders.services.LojaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@Api("API - Lojas")
@RestController
@RequestMapping("/loja")
public class LojaController {
	
	@Autowired
	LojaService lojaService;
	
	@ApiOperation(value = "Adição de Lojas no sistema")
	@PostMapping
	public ResponseEntity<String> create(@RequestBody LojaDTO dto){
		lojaService.create(dto);
		return new ResponseEntity<>("Loja adicionada ao sistema com sucesso", HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Busca por todas as lojas")
	@GetMapping("/todas")
	public ResponseEntity<List<Loja>> getAll(){
		return new ResponseEntity<List<Loja>>(lojaService.getAll(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Busca de loja específico por Id")
	@GetMapping("/{id}")
	public ResponseEntity<Loja> getById(@PathVariable Long id){
		return new ResponseEntity<Loja>(lojaService.findById(id),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Alteração de loja passando o Id para busca")
	@PutMapping("/alterar/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody LojaDTO dto){
		lojaService.update(id, dto);
		return new ResponseEntity<>("Dados da loja atualizado com sucesso", HttpStatus.ACCEPTED);
	}
	
	@ApiOperation(value = "Exclusão de loja do sistema")
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		return new ResponseEntity<String>(lojaService.delete(id),HttpStatus.ACCEPTED);
	}

}
