package com.tcc.safehome.dto;

import java.io.Serializable;
import java.util.Date;

import com.tcc.safehome.domain.DeteccaoMovimento;

public class DeteccaoMovimentoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date ultimaDeteccao;
	
	public DeteccaoMovimentoDTO() {	
	}
	
	public DeteccaoMovimentoDTO(DeteccaoMovimento obj) {	
		id = obj.getId();
		ultimaDeteccao = obj.getUltimaDeteccao();
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
}
