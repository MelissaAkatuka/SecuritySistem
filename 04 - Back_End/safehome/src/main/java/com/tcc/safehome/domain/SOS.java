package com.tcc.safehome.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="SOS")
public class SOS implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SOS_ID")
	private Integer id;
	
	@Column(name="SOS_MENSAGEM")
	private String mensagem;
	
	@Column(name="SOS_CEL1")
	private String cel1;
	
	@Column(name="SOS_CEL2")
	private String cel2;
	
	@Column(name="SOS_CEL3")
	private String cel3;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="USU_ID")
	private Usuario usuario;
	
	public SOS() {
	}
	
	public SOS(Integer id, String mensagem, String cel1, String cel2, String cel3, Usuario usuario) {
		super();
		this.id = id;
		this.mensagem = mensagem;
		this.cel1 = cel1;
		this.cel2 = cel2;
		this.cel3 = cel3;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getCel1() {
		return cel1;
	}

	public void setCel1(String cel1) {
		this.cel1 = cel1;
	}

	public String getCel2() {
		return cel2;
	}

	public void setCel2(String cel2) {
		this.cel2 = cel2;
	}

	public String getCel3() {
		return cel3;
	}

	public void setCel3(String cel3) {
		this.cel3 = cel3;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		SOS other = (SOS) obj;
		return Objects.equals(id, other.id);
	}

}

