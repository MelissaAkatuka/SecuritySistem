package com.tcc.safehome.dto;

import java.io.Serializable;

import com.tcc.safehome.domain.SOS;

public class SOSDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String mensagem;
	private String cel1;
	private String cel2;
	private String cel3;
	
	public SOSDTO() {	
	}
	
	public SOSDTO(SOS obj) {	
		id = obj.getId();
		mensagem = obj.getMensagem();
		cel1 = obj.getCel1();
		cel2 = obj.getCel2();
		cel3 = obj.getCel3();
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
}
