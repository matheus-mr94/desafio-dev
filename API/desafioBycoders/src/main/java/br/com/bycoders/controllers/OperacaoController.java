package br.com.bycoders.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bycoders.dtos.OperacaoDTO;
import br.com.bycoders.services.OperacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@Api("API - Operações")
@RestController
@RequestMapping("/operacao")
public class OperacaoController {
	
	@Autowired
	OperacaoService operacaoService;
	
	@ApiOperation(value = "Realização de operação")
	@PostMapping
	public ResponseEntity<String> create (@RequestBody OperacaoDTO dto) throws Exception{
		operacaoService.create(dto);
		return new ResponseEntity<>("Operação realizada com sucesso", HttpStatus.ACCEPTED);
	}

}
