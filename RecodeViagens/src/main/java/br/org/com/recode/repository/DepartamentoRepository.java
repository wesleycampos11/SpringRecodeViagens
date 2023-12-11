package br.org.com.recode.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import br.org.com.recode.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
