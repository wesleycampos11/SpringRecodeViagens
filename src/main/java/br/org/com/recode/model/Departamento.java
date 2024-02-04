package br.org.com.recode.model;


import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; 


@Entity
@Table(name = "departamento")
public class Departamento {

	// ATRIBUTOS

	@Id
	// IDENTITY = CHAVE PRIMÁRIA E AUTOINCREMENT
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codDepartamento;

	@Column(nullable = false, length = 15)
	private String nome;
	
	public Departamento() {}

	// CONSTRUTOR
	public Departamento(Long codDepartamento, String nome) {
		super();
		this.codDepartamento = codDepartamento;
		this.nome = nome;
	}

	// GETTERS E SETTERS
	public Long getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(Long codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// HASHCODE E EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(codDepartamento, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(codDepartamento, other.codDepartamento) && Objects.equals(nome, other.nome);
	}

	
	// TO STRING
	@Override
	public String toString() {
		return "Departamento [codDepartamento=" + codDepartamento + ", nome=" + nome + "]";
	}

	

	
	
	
}
