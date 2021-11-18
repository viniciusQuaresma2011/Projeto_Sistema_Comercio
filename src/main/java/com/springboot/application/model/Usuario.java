package com.springboot.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="email" )
	private String email;
	
	@Column(name="nome_usuario")
	private String nomeUsuario;
	
	@Column(name="filial")
	private String filial;
	
	
	@Column(name="setor")
	private String setor;
	
	@Column(name="funcao")
	private String funcao;
	
	
	

	public Usuario() {
		super();
	}

	public Usuario(Long id, String nome, String email, String nomeUsuario, String filial, String setor, String funcao) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.nomeUsuario = nomeUsuario;
		this.filial = filial;
		this.setor = setor;
		this.funcao = funcao;
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

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	
	
	
	
}
