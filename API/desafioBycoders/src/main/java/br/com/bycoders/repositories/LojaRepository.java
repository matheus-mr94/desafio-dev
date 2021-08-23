package br.com.bycoders.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bycoders.models.Loja;

public interface LojaRepository extends JpaRepository<Loja, Long> {

	Optional<Loja> findByCpfBeneficiario(String cpf);

}
