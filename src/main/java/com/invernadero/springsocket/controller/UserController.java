package com.invernadero.springsocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.invernadero.springsocket.model.User;
import com.invernadero.springsocket.model.UserResponse;
import com.invernadero.springsocket.sensores.Conexion_Serial;

@Controller
public class UserController {

	@MessageMapping("/user")
	@SendTo("/topic/user")
	public UserResponse getUser(User user) {
		return new UserResponse("hii", "ttt");
	}
}
