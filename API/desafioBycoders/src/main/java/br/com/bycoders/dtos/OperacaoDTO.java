package br.com.bycoders.dtos;

import java.time.LocalDate;

import br.com.bycoders.enums.TipoTransacao;
import br.com.bycoders.models.Loja;

public class OperacaoDTO {

	private Double valor;
	private String cartao;
	private LocalDate data;
	private TipoTransacao tipoTransacao;
	private String hora;
	private Loja loja;

	

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

}
