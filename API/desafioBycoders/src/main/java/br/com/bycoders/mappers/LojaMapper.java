package br.com.bycoders.mappers;

import org.springframework.stereotype.Component;

import br.com.bycoders.dtos.LojaDTO;
import br.com.bycoders.models.Loja;

@Component
public class LojaMapper {

	public Loja toEntity(LojaDTO dto) {
		Loja loja = new Loja();
		loja.setNomeDono(dto.getNomeDono());
		loja.setNomeLoja(dto.getNomeLoja());
		loja.setOperacoes(dto.getOperacoes());
		loja.setSaldo(dto.getSaldo());
		loja.setCpfBeneficiario(dto.getCpfBeneficiario());
		return loja;
	}
	
	public LojaDTO toDTO(Loja loja) {
		LojaDTO dto = new LojaDTO();
		dto.setNomeDono(loja.getNomeDono());
		dto.setNomeLoja(loja.getNomeLoja());
		dto.setOperacoes(loja.getOperacoes());
		dto.setSaldo(loja.getSaldo());
		dto.setCpfBeneficiario(loja.getCpfBeneficiario());
		return dto;
	}
	
}
