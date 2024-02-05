package br.org.com.recode.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "faleConosco")
public class FaleConosco {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
    private String nome;
	
	@Column(nullable = false, length = 50)
    private String email;
	
	@Column(nullable = false, length = 200)
    private String mensagem;
	
	@Column(nullable = false, length = 20)
    private String assunto;
	
	@Column(nullable = false, length = 15)
    private String telefone;
	
	@Column(nullable = true, name = "dataContato")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataContato;
	
	@Column(nullable = true, name = "dataResposta")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataResposta;
	
	@Column(nullable = true, length = 20)
    private String status;
	
	public FaleConosco() {}

	public FaleConosco(Long id, String nome, String email, String mensagem,String assunto,String telefone, LocalDate dataContato,
			LocalDate dataResposta, String status) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.mensagem = mensagem;
		this.assunto = assunto;
		this.telefone = telefone;
		this.dataContato = dataContato;
		this.dataResposta = dataResposta;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void settelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getMensagem() {
		return mensagem;
	}
	

    public String getAssunto() {
        return assunto;
    }
    

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public LocalDate getDataContato() {
		return dataContato;
	}

	public void setDataContato(LocalDate dataContato) {
		this.dataContato = dataContato;
	}

	public LocalDate getDataResposta() {
		return dataResposta;
	}

	public void setDataResposta(LocalDate dataResposta) {
		this.dataResposta = dataResposta;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}
