package com.tcc.safehome.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USUARIOS")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USU_ID")
	private Integer id;
	
	@Column(name="USU_NOME")
	private String nome;
	
	@Column(name="USU_SOBRENOME")
	private String sobrenome;
	
	@Column(name="USU_NOME_USUARIO")
	private String nomeUsuario;
	
	@Column(name="USU_SENHA")
	private String senha;
	
	@Column(name="USU_CELULAR")
	private String celular;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="usuario")
	private SOS sos;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="usuario")
	private Casa casa;
	
	public Usuario() {
	}

	public Usuario(Integer id, String nome, String sobrenome, String nomeUsuario, String senha, String celular) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.celular = celular;
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
	
	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}
	
	public SOS getSos() {
		return sos;
	}

	public void setSos(SOS sos) {
		this.sos = sos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
}
