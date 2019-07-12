package com.invernadero.springsocket.service;

import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.invernadero.springsocket.model.Temperatura;

//@Service indica que la clase es un bean de la capa de negocio
@Service
public class TemperaturaDB{
	
	private JdbcTemplate jdbcTemplate;	
	@Autowired
	public void setDataSource(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@SuppressWarnings("deprecation")
	public List<Map<String,Object>> listarTemperatura(){
		String xsql="select * from temperatura;";
		return this.jdbcTemplate.queryForList(xsql, new Object[] {});
	}
	public int guardarTemperatura(Temperatura temperatura) {
		String xsql="INSERT INTO temperatura(grados, humedad, fecha) VALUES (?, ?, ?);";
		return this.jdbcTemplate.update(xsql, 
				new Object[] {temperatura.getGrados(),
							  temperatura.getHumedad(),
							  temperatura.getDate()
							 });		
	}
	/*public Map<String,Object> modUsuario(String ci){
		String xsql="select * from usuario where(ci=?) ";
		return this.jdbcTemplate.queryForMap(xsql, new Object[] {Integer.parseInt(ci)});
	}
	public int modificarUsuario(String ci, String nombre, String ap, String am, String telefono) {
		String xsql="update usuario set nombre=?,ap=?,am=?,telefono=? where (ci=?)";
		return this.jdbcTemplate.update(xsql, new Object[] {nombre,ap,am,Integer.parseInt(telefono),Integer.parseInt(ci)});
		
	}
	public int borrarUsuario(String ci) {
		String xsql="update usuario set estado=false where (ci=?)";
		return this.jdbcTemplate.update(xsql, new Object[] {Integer.parseInt(ci)});
		
	}*/
	
}
