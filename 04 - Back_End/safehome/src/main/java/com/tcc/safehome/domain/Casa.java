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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CASA")
public class Casa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CAS_ID")
	private Integer id;
	
	@Column(name="CAS_SENSOR_LIGADO")
	private String sensorLigado;
	
	@Column(name="CAS_MODO_MONITORAMENTO")
	private String modoMonitoramento;
	
	@OneToMany(mappedBy="casa")
	private List<Ambiente> ambientes = new ArrayList<>();
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="USU_ID")
	private Usuario usuario;
	
	public Casa(){
	}
	
	public Casa(Integer id, String sensorLigado, String modoMonitoramento, Usuario usuario) {
		super();
		this.id = id;
		this.sensorLigado = sensorLigado;
		this.modoMonitoramento = modoMonitoramento;
		this.usuario = usuario;
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
	
	public List<Ambiente> getAmbientes() {
		return ambientes;
	}

	public void setAmbientes(List<Ambiente> ambientes) {
		this.ambientes = ambientes;
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
		Casa other = (Casa) obj;
		return Objects.equals(id, other.id);
	}
}
	
	
