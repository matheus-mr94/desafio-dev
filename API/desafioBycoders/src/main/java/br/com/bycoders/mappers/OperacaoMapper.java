package br.com.bycoders.mappers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.bycoders.dtos.OperacaoDTO;
import br.com.bycoders.models.Operacao;

@Component
public class OperacaoMapper {
	
	private String getDateTime() {
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date data = new Date();
		return df.format(data);
	}

	 
	public Operacao toEntity(OperacaoDTO dto) {
		Operacao operacao = new Operacao();		
		operacao.setTipoTransacao(dto.getTipoTransacao());
		operacao.setData(LocalDate.now());
		operacao.setHora(getDateTime());
		operacao.setValor(dto.getValor());
		operacao.setCartao(dto.getCartao());
		operacao.setLoja(dto.getLoja());
		return operacao;
		
	}

}
