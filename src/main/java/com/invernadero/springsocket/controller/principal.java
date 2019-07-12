package com.invernadero.springsocket.controller;

import java.io.*;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.invernadero.springsocket.service.ControlDb;

@Controller
public class principal {

	@Autowired
	ControlDb controlDb;

	@RequestMapping(value = "/" , method = RequestMethod.GET ) 
	public String inicio() throws IOException {		
		//ModelAndView modelAndView = new ModelAndView("/index.html");		
		return "index";
	}

	@RequestMapping(value = "/validar",method = RequestMethod.POST)
	public String validar(HttpServletRequest request, HttpServletResponse response, Model model,
		@RequestParam String user, String pass) throws IOException {
		String mensaje = "";		
		int contador = controlDb.valida(user, pass);
		if (contador == 1) {
			response.sendRedirect("principal.html");
		}
		mensaje = "usuario y/o password incorrectos";
		model.addAttribute("aviso", mensaje);
		return "index";
	}

	@RequestMapping({ "principal.html" })
	public String principal(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

		return "principal";
	}

	@RequestMapping({ "index2.html" })
	public String prueba(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

		return "index2";
	}

}