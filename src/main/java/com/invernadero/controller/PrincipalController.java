package com.invernadero.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.invernadero.service.CuentaAccessService;

@Controller
public class PrincipalController {

	@Autowired
	CuentaAccessService usuario;
	private String mensaje = "";
	@GetMapping(value = "/") 
	public String inicio(Model model) throws IOException {		
		return "login";
	}

	@PostMapping(value = "/validar")
	public String validar(HttpServletRequest request, HttpServletResponse response, Model model,
		@RequestParam String user, String pass) throws IOException {
		
		if (usuario.validaLogin(user, pass)) {
			response.sendRedirect("principal.html");
		}
		
		mensaje = "usuario y/o password incorrectos";
		model.addAttribute("login-message", mensaje);
		return "login";
	}

	@RequestMapping({ "principal.html" })
	public String principal(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		return "principal";
	}
}