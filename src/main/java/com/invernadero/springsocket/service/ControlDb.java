package com.invernadero.springsocket.service;

import java.util.*;

import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

//@Service indica que la clase es un bean de la capa de negocio
@Service
public class ControlDb {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	//@SuppressWarnings("deprecation")
	public int valida(String user,String pass){
		String xsql="select count(*) from datos d,usuario u where (d.clave=?) and(d.usuario=?)and(d.ci=u.ci)and(u.estado='t') ";
		//return this.jdbcTemplate.queryForInt(xsql, new Object[]{pass,user});
		Number number = jdbcTemplate.queryForObject(xsql, new Object[]{pass,user},Integer.class);
		return (number != null ? number.intValue() : 0);
	}
}
