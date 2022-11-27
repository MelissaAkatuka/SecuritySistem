package com.tcc.safehome.dto;

import java.io.Serializable;

import com.tcc.safehome.domain.Usuario;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String sobrenome;
	private String nomeUsuario;
	private String senha;
	private String celular;
	
	public UsuarioDTO() {	
	}
	
	public UsuarioDTO(Usuario obj) {	
		id = obj.getId();
		nome = obj.getNome();
		sobrenome = obj.getSobrenome();
		nomeUsuario = obj.getNomeUsuario();
		senha = obj.getSenha();
		celular = obj.getCelular();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
}
