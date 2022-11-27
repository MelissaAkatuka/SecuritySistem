package com.tcc.safehome.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="AMBIENTES")
public class Ambiente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AMB_ID")
	private Integer id;
	
	@Column(name="AMB_NOME")
	private String nome;
	
	@Column(name="AMB_PORTA_ARDUINO")
	private String portaArduino;
	
	@OneToMany(mappedBy="ambientes")
	private List<DeteccaoMovimento> deteccoesMovimento = new ArrayList<>();
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="CAS_ID")
	private Casa casa;
	
	public Ambiente() {
	}
	
	public Ambiente(Integer id, String nome, String portaArduino, Casa casa) {
		super();
		this.id = id;
		this.nome = nome;
		this.portaArduino = portaArduino;
		this.casa = casa;
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
	public String getPortaArduino() {
		return portaArduino;
	}
	public void setPortaArduino(String portaArduino) {
		this.portaArduino = portaArduino;
	}
	public List<DeteccaoMovimento> getDeteccoesMovimento() {
		return deteccoesMovimento;
	}
	public void setDeteccoesMovimento(List<DeteccaoMovimento> deteccoesMovimento) {
		this.deteccoesMovimento = deteccoesMovimento;
	}
	public Casa getCasa() {
		return casa;
	}
	public void setCasa(Casa casa) {
		this.casa = casa;
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
		Ambiente other = (Ambiente) obj;
		return Objects.equals(id, other.id);
	}
}
