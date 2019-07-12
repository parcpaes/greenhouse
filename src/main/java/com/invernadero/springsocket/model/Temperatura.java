package com.invernadero.springsocket.model;

import java.util.Date;

public class Temperatura {
	private long id;
	private double grados;
	private double humedad;
	private Date date;
	public Temperatura() {
		// TODO Auto-generated constructor stub
	}
	public Temperatura (double grados,double humedad,Date date){
		this.grados= grados;
		this.humedad = humedad;
		this.date = date;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getGrados() {
		return grados;
	}
	public void setGrados(double grados) {
		this.grados = grados;
	}
	public double getHumedad() {
		return humedad;
	}
	public void setHumedad(double humedad) {
		this.humedad = humedad;
	}	
}
