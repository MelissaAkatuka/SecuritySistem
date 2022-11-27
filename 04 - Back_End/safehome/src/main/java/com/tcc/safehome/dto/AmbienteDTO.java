package com.tcc.safehome.dto;

import java.io.Serializable;

import com.tcc.safehome.domain.Ambiente;

public class AmbienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String portaArduino;
	
	public AmbienteDTO() {	
	}
	
	public AmbienteDTO(Ambiente obj) {
		id = obj.getId();
		nome = obj.getNome();
		portaArduino = obj.getPortaArduino();
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

	
}
