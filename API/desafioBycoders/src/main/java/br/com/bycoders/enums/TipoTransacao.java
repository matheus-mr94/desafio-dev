package br.com.bycoders.enums;

public enum TipoTransacao {

	DEBITO(1, "Entrada", "+"),
	BOLETO(2, "Saída", "-"),
	FINANCIAMENTO(3, "Saída", "-"),
	CREDITO(4, "Entrada", "+"),
	RECEBIMENTO_EMPRESTIMO(5, "Entrada", "+"),
	VENDAS(6, "Entrada", "+"),
	RECEBIMENTO_TED(7, "Entrada", "+"),
	RECEBIMENTO_DOC(8, "Entrada", "+"),
	ALUGUEL(9, "Saída", "-");

	private Integer codigo;
	private String natureza;
	private String sinal;

	private TipoTransacao(Integer codigo, String natureza, String sinal) {
		this.codigo = codigo;
		this.natureza = natureza;
		this.sinal = sinal;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public String getSinal() {
		return sinal;
	}

	public void setSinal(String sinal) {
		this.sinal = sinal;
	}

}
