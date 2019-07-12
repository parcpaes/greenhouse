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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invernadero.springsocket.service.PersonalService;

@Controller
public class usuario {

	@Autowired
	PersonalService usuarioDb;
	
	//@GetMapping("/students")
	@RequestMapping("/usuarios")
	public String gestionUsuario(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {
		List<?> listadeusuario = usuarioDb.listaUsuarios();
		System.out.println(listadeusuario.size());
		model.addAttribute("lusuario", listadeusuario);
		return "Usuario/gestionUsuarios";
	}

	@RequestMapping({ "addusuario.html" })
	public String addUsuario(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

		System.out.println("llego a usuario");

		return "Usuario/addUsuario";
	}

	@RequestMapping({ "guardarusuario.html" })
	public String guardarUsuario(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam String nombre, String ap, String am, String telefono, String cedula) throws IOException {
		String mensaje;
		try {
			usuarioDb.guardarUsuario(cedula, nombre, ap, am, telefono);

			mensaje = "SE ADICIONO CORRECTAMENTE LOS DATOS";
		} catch (Exception e) {

			mensaje = "HUBO UN ERROR AL GUARDAR LOS DATOS";
		}

		List<?> listadeusuario = usuarioDb.listaUsuarios();

		model.addAttribute("lusuario", listadeusuario);
		model.addAttribute("mensaje", mensaje);

		return "Usuario/gestionUsuarios";
	}

	@RequestMapping({ "modificarusuario.html" })
	public String modUsuario(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam String ci) throws IOException {
		String mensaje;

		Map<String, Object> usuario = this.usuarioDb.modUsuario(ci);

		model.addAttribute("usuario", usuario);
		return "Usuario/modUsuario";

	}

	@RequestMapping({ "guardarModusuario.html" })
	public String guardarModUsuario(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam String nombre, String ap, String am, String telefono, String cedula) throws IOException {
		String mensaje;
		try {
			usuarioDb.modificarUsuario(cedula, nombre, ap, am, telefono);

			mensaje = "SE MODIFICO CORRECTAMENTE LOS DATOS";
		} catch (Exception e) {

			mensaje = "HUBO UN ERROR AL GUARDAR LOS DATOS";
		}

		List<?> listadeusuario = usuarioDb.listaUsuarios();

		model.addAttribute("lusuario", listadeusuario);
		model.addAttribute("mensaje", mensaje);

		return "Usuario/gestionUsuarios";
	}

	@RequestMapping({ "borrarusuario.html" })
	public String borrarUsuario(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam String ci) throws IOException {
		String mensaje;
		try {
			usuarioDb.borrarUsuario(ci);

			mensaje = "SE ELIMINO CORRECTAMENTE LOS DATOS";
		} catch (Exception e) {

			mensaje = "HUBO UN ERROR AL GUARDAR LOS DATOS";
		}

		List<?> listadeusuario = usuarioDb.listaUsuarios();

		model.addAttribute("lusuario", listadeusuario);
		model.addAttribute("mensaje", mensaje);

		return "Usuario/gestionUsuarios";
	}

}