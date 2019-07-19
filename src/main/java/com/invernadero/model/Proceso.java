package com.invernadero.model;

import java.io.Serializable;
import java.net.URL;

public class Proceso implements Serializable{
	private Integer cod_proceso;
	private String name;
	private String description;
	private URL url;
	
	public Proceso() {
		
	}
	public Integer getCod_proceso() {
		return cod_proceso;
	}
	public void setCod_proceso(Integer cod_proceso) {
		this.cod_proceso = cod_proceso;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL url) {
		this.url = url;
	}
	
}
