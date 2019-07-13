package com.invernadero.sensores;

import java.util.Date;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.invernadero.model.Temperatura;
import com.invernadero.model.UserResponse;
import com.invernadero.service.SerialCommunicationService;
import com.invernadero.service.TemperaturaDB;

@EnableScheduling
@Configuration
public class SensoresConfiguaration {
	
	
	//connection de datos con arduino and socket
	//enviando datos de emperatura
	@Autowired
	SerialCommunicationService serialCommunicationService;
	
	@Autowired
	TemperaturaDB temperaturadb;
	@Autowired
	SimpMessagingTemplate template;
	@Scheduled(fixedDelay = 10200) // actualizacion
	public void setAddMessage() throws InterruptedException {
		(new Thread()).sleep(800);//retardo re respuesta
		String temperature[] = serialCommunicationService.readLine().split(",");
		if(temperature.length>0){
			
			Temperatura temp = new Temperatura();
			temp.setGrados(Double.parseDouble(temperature[0]));
			temp.setHumedad(Double.parseDouble(temperature[1]));
			temp.setDate(new Date());

			temperaturadb.guardarTemperatura(temp);//enviando datos al DB
			template.convertAndSend("/topic/temperatura",temp);//javascript ruta	
		}
	}
	
	
	/*@Autowired
	SimpMessagingTemplate template2;
	@Scheduled(fixedDelay = 10200) // actualizacion
	public void setTemperaturaTierra() throws InterruptedException {
		(new Thread()).sleep(800);//retardo re respuesta
		String temperature[] = serialCommunicationService.readLine().split(",");
		if(temperature.length>0){
			
			Temperatura temp = new Temperatura();
			temp.setGrados(Double.parseDouble(temperature[0]));
			temp.setHumedad(Double.parseDouble(temperature[1]));
			temp.setDate(new Date());

			temperaturadb.guardarTemperatura(temp);//enviando datos al DB
			template2.convertAndSend("/topic/temperaturaTierra",temp);//javascript ruta	
		}
	}*/
}
