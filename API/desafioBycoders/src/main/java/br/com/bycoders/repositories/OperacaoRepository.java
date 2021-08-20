package br.com.bycoders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bycoders.models.Operacao;

public interface OperacaoRepository extends JpaRepository<Operacao, Long>{

}
