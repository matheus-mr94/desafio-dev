package br.com.bycoders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bycoders.models.Loja;

public interface LojaRepository extends JpaRepository<Loja, Long> {

}
