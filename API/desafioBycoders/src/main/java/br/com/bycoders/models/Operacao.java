package br.com.bycoders.models;

import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Operacao {

	private String cpfBeneficiario;
	private Double valor;
	private LocalDate data;
	private String tipoTransacao;
	private Time hora;
	
	private Loja loja;

	public String getCpfBeneficiario() {
		return cpfBeneficiario;
	}

	public void setCpfBeneficiario(String cpfBeneficiario) {
		this.cpfBeneficiario = cpfBeneficiario;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

}
