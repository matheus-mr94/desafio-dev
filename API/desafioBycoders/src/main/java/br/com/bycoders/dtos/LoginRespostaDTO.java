package br.com.bycoders.dtos;

import br.com.bycoders.models.Usuario;

public class LoginRespostaDTO {

	private String token;
	private Usuario usuario;
	
	
	public LoginRespostaDTO(String token, Usuario usuario) {
		super();
		this.token = token;
		this.usuario = usuario;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

}
