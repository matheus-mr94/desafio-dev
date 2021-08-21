package br.com.bycoders.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bycoders.dtos.LoginRequisicaoDTO;
import br.com.bycoders.dtos.LoginRespostaDTO;
import br.com.bycoders.exceptions.EmailOrPasswordNotValidException;
import br.com.bycoders.services.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@Api("API - Login")
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@ApiOperation(value = "Requisição de login")
    @PostMapping
    public LoginRespostaDTO login (@RequestBody LoginRequisicaoDTO request) throws EmailOrPasswordNotValidException {    	
        return usuarioService.logar(request.getEmail(), request.getSenha());
    }


}
