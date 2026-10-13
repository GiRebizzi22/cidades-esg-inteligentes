package br.com.esg.cidades.repository;

import br.com.esg.cidades.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {}
