package com.invernadero.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.*;
import org.springframework.stereotype.Service;

import com.invernadero.sensores.Conexion_Serial;

import java.util.concurrent.ConcurrentHashMap;
import gnu.io.CommPortIdentifier;

@Service
public class SerialCommunicationService {
	
	private ConcurrentHashMap<String, Conexion_Serial> serialCommunicationMap = new ConcurrentHashMap<String, Conexion_Serial>();	
	private final String PORT = "COM9";
	
	public synchronized void stop(String portName) {
		Conexion_Serial serialCommunication = serialCommunicationMap.remove(PORT);
		if (serialCommunication != null) {
			serialCommunication.close();
		}
	}
	
	public synchronized void write(String value) {
		Conexion_Serial serialCommunication = serialCommunicationMap.get(PORT);
		if (serialCommunication == null) {
 			serialCommunication = new Conexion_Serial(PORT);
 			serialCommunication.initialize();
			serialCommunicationMap.put(PORT, serialCommunication);
		}
		
		serialCommunication.send(value);
		
	}
	
	//reciviendo datos del arduino 
	public synchronized String readLine() {
		String portName = PORT;
		Conexion_Serial serialCommunication = serialCommunicationMap.get(portName);		
		if (serialCommunication == null) {
 			serialCommunication = new Conexion_Serial(portName);
 			serialCommunication.initialize();
			serialCommunicationMap.put(portName, serialCommunication);
		}
		return serialCommunication.read();
	}
	
	public Collection<String> getPorts() {
		List<String> ports = new ArrayList<String>();
		
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		//First, Find an instance of serial port as set in PORT_NAMES.
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			ports.add(currPortId.getName());
		}
		
		return ports;
	}
}
