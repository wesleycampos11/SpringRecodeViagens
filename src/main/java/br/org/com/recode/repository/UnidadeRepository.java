package br.org.com.recode.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import br.org.com.recode.model.Unidade;

public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

}
