package com.invernadero.springsocket.controller;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class arduino {

	//Conexion_Serial arduino = new Conexion_Serial("COM9");
	//public int controlInicioArduino = 0;

	/*
	 * @Autowired ControlManager controlManager;
	 */
	// @RequestParam(required=false) String led
	/*@RequestMapping({ "controles.html" })
	public String inicio(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		String message = "";
		arduino.initialize();
		// System.out.println("here: "+led);
		// arduino.send(led);
		TimerTask task = new TimerTask() {
			@Override
			String val = message;

			public void run() {
				// TODO Auto-generated method stub
				System.out.println(arduino.read());
			}
		};
		Timer time = new Timer();
		time.schedule(task, 50, 2000);

		model.addAttribute("aviso", message);

		return "controles";
	}*/
}
