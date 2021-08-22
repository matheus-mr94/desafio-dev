package br.com.bycoders.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bycoders.dtos.LojaDTO;
import br.com.bycoders.mappers.LojaMapper;
import br.com.bycoders.models.Loja;
import br.com.bycoders.repositories.LojaRepository;

@Service
public class LojaService {
	
	@Autowired
	LojaRepository lojaRepository;
	
	@Autowired
	LojaMapper lojaMapper;
	
	public Loja findById(Long id) {
		return lojaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Id número" + id + " não encontrado"));
	}
	
	public Loja create(LojaDTO dto) {
		Loja loja = lojaMapper.toEntity(dto);
		return lojaRepository.save(loja);
	}
	
	public List<Loja> getAll() {
		return lojaRepository.findAll();
	}
	
	public LojaDTO update(Long id, LojaDTO dto) {
		Loja loja = this.findById(id);
		loja.setNomeDono(dto.getNomeDono());
		loja.setNomeLoja(dto.getNomeLoja());
		loja.setSaldo(dto.getSaldo());
		loja.setOperacoes(dto.getOperacoes());
		loja.setCpfBeneficiario(dto.getCpfBeneficiario());
		return lojaMapper.toDTO(lojaRepository.save(loja));
	}
	
	public String delete(Long id) {
		lojaRepository.deleteById(id);
		return "Loja removida com sucesso";
	}

}
