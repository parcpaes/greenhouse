package com.invernadero.springsocket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Sensores {
	
	@RequestMapping("/sensortemp")
	public String gestionUsuario(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {
		return "temperatura";
	}
}
