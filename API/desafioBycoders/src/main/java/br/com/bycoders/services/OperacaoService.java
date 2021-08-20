package br.com.bycoders.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bycoders.dtos.OperacaoDTO;
import br.com.bycoders.mappers.OperacaoMapper;
import br.com.bycoders.models.Operacao;
import br.com.bycoders.repositories.OperacaoRepository;

@Service
public class OperacaoService {
	
	@Autowired
	OperacaoMapper operacaoMapper;
	
	@Autowired
	OperacaoRepository operacaoRepository;
	
	public Operacao create(OperacaoDTO dto) {
		Operacao operacao = operacaoMapper.toEntity(dto);
		return operacaoRepository.save(operacao);
	}

}
