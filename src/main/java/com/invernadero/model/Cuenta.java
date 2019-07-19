package com.invernadero.model;

import java.io.Serializable;
import java.util.List;


public class Cuenta implements Serializable{
	private String usuario;
	private String clave;
	private long ci;
	private List<Personal> personal;
	
	public Cuenta() {
		
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public long getCi() {
		return ci;
	}
	public void setCi(long ci) {
		this.ci = ci;
	}
	public List<Personal> getPersonal() {
		return personal;
	}
	public void setPersonal(List<Personal> personal) {
		this.personal = personal;
	}
	
}
