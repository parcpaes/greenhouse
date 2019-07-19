package com.invernadero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class SpringsocketApplication extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(SpringsocketApplication.class, args);
	}
}
