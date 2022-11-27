package com.tcc.safehome.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="DETECCOES_MOVIMENTO")
public class DeteccaoMovimento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MOV_ID")
	private Integer id;
	
	@Column(name="MOV_ULTIMA_DETECCAO")
	private Date ultimaDeteccao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="AMB_ID")
	private Ambiente ambientes;
	
	public DeteccaoMovimento() {
	}
	
	public DeteccaoMovimento(Integer id, Date ultimaDeteccao, Ambiente ambientes) {
		super();
		this.id = id;
		this.ultimaDeteccao = ultimaDeteccao;
		this.ambientes = ambientes;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getUltimaDeteccao() {
		return ultimaDeteccao;
	}
	public void setUltimaDeteccao(Date ultimaDeteccao) {
		this.ultimaDeteccao = ultimaDeteccao;
	}
	public Ambiente getAmbientes() {
		return ambientes;
	}

	public void setAmbientes(Ambiente ambientes) {
		this.ambientes = ambientes;
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
		DeteccaoMovimento other = (DeteccaoMovimento) obj;
		return Objects.equals(id, other.id);
	}
}
