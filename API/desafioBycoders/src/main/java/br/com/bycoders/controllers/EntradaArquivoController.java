package br.com.bycoders.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.bycoders.services.EntradaArquivoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin("*")
@Api("API - Entrada de arquivo .csv - com divisor ';'")
@RestController
@RequestMapping("/arquivo")
public class EntradaArquivoController {

	@Autowired
	EntradaArquivoService arquivoService;
	
	@ApiOperation(value = "Upload de arquivo csv")
	@PostMapping
	public ResponseEntity<String> LeituraArquivo(@RequestParam MultipartFile file){
		try {
			arquivoService.LeituraArquivos(file.getInputStream());
			return new ResponseEntity<String>("Leitura realizada com sucesso",HttpStatus.OK);
		}catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<String>("Erro ao fazer leitura",HttpStatus.BAD_REQUEST);
	}
}
