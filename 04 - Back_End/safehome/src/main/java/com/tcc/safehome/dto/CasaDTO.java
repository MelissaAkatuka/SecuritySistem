package com.tcc.safehome.dto;

import java.io.Serializable;

import com.tcc.safehome.domain.Casa;

public class CasaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String sensorLigado;
	private String modoMonitoramento;
	
	public CasaDTO() {	
	}
	
	public CasaDTO(Casa obj) {	
		id = obj.getId();
		sensorLigado = obj.getSensorLigado();
		modoMonitoramento = obj.getModoMonitoramento();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSensorLigado() {
		return sensorLigado;
	}

	public void setSensorLigado(String sensorLigado) {
		this.sensorLigado = sensorLigado;
	}

	public String getModoMonitoramento() {
		return modoMonitoramento;
	}

	public void setModoMonitoramento(String modoMonitoramento) {
		this.modoMonitoramento = modoMonitoramento;
	}
}
