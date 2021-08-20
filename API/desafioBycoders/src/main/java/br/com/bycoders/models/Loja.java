package br.com.bycoders.models;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Loja {
	
	private String nomeLoja;
	private String nomeDono;
	private Double saldo;
	
	
	private List<Operacao> operacoes;
	
	
	public String getNomeLoja() {
		return nomeLoja;
	}
	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}
	public String getNomeDono() {
		return nomeDono;
	}
	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public List<Operacao> getOperacoes() {
		return operacoes;
	}
	public void setOperacoes(List<Operacao> operacoes) {
		this.operacoes = operacoes;
	}
}
