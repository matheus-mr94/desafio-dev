package br.com.bycoders.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bycoders.dtos.OperacaoDTO;
import br.com.bycoders.mappers.LojaMapper;
import br.com.bycoders.mappers.OperacaoMapper;
import br.com.bycoders.models.Loja;
import br.com.bycoders.models.Operacao;
import br.com.bycoders.repositories.LojaRepository;
import br.com.bycoders.repositories.OperacaoRepository;

@Service
public class OperacaoService {

	@Autowired
	OperacaoMapper operacaoMapper;

	@Autowired
	OperacaoRepository operacaoRepository;

	@Autowired
	LojaRepository lojaRepository;

	@Autowired
	LojaMapper lojaMapper;

	@Autowired
	LojaService lojaService;

	public Operacao create(OperacaoDTO dto) throws Exception {
		Operacao operacao = operacaoMapper.toEntity(dto);
		Optional<Loja> loja  = lojaRepository.findById(operacao.getLoja().getId());
		
		if (loja.isPresent()) {
			double novoSaldo;
			double saldoLoja = loja.get().getSaldo();
			double valorOperacao = operacao.getValor();
			if (operacao.getTipoTransacao().getSinal().equals("+")) {
				 novoSaldo = saldoLoja + valorOperacao;
				 loja.get().setSaldo(novoSaldo);
			}else if(saldoLoja >= valorOperacao){					 
				 novoSaldo = saldoLoja - valorOperacao;
					loja.get().setSaldo(novoSaldo);
			}else
			throw new Exception("Saldo insuficiente");
		}
		return operacaoRepository.save(operacao);
	}
}
