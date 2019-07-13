package com.invernadero.service;


import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

//@Service indica que la clase es un bean de la capa de negocio
@Service
public class PersonalService{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@SuppressWarnings("deprecation")
	public List<Map<String,Object>> listaUsuarios(){
		String xsql="select * from personal where (estado = true)";
		return this.jdbcTemplate.queryForList(xsql, new Object[] {});
	}
	public int guardarUsuario(String ci, String nombre, String ap, String am, String telefono) {
		String xsql="insert into personal(ci,nombre,ap,am,telefono) values(?,?,?,?,?)";
		return this.jdbcTemplate.update(xsql, new Object[] {Integer.parseInt(ci),nombre,ap,am,Integer.parseInt(telefono)});
	}
	public Map<String,Object> modUsuario(String ci){
		String xsql="select * from personal where(ci=?) ";
		return this.jdbcTemplate.queryForMap(xsql, new Object[] {Integer.parseInt(ci)});
	}
	public int modificarUsuario(String ci, String nombre, String ap, String am, String telefono) {
		String xsql="update personal set nombre=?,ap=?,am=?,telefono=? where (ci=?)";
		return this.jdbcTemplate.update(xsql, new Object[] {nombre,ap,am,Integer.parseInt(telefono),Integer.parseInt(ci)});
	}
	public int borrarUsuario(String ci) {
		String xsql="update personal set estado=false where (ci=?)";
		return this.jdbcTemplate.update(xsql, new Object[] {Integer.parseInt(ci)});
	}

}
