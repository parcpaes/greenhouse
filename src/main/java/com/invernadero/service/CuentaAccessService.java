package com.invernadero.service;

import java.util.*;

import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

//@Service indica que la clase es un bean de la capa de negocio
@Service
public class CuentaAccessService {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	//@SuppressWarnings("deprecation")
	public boolean valida(String user,String pass) throws DataAccessException {		
		String xsql="select count(*) from cuenta d, personal u where (d.clave=?)"
				+ " and(d.usuario=?)and(d.ci=u.ci)and(u.estado='t') ";
		//return this.jdbcTemplate.queryForInt(xsql, new Object[]{pass,user});
		
		Boolean validar  = jdbcTemplate.queryForObject(xsql, new Object[]{pass,user},Boolean.class);
		return validar;
	}
}
