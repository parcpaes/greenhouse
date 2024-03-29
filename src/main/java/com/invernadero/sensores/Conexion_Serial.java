package com.invernadero.sensores;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;


public class Conexion_Serial implements SerialPortEventListener {

    private SerialPort serialPort;
    private final String namePort;

    public Conexion_Serial(String portName) {
        this.namePort = portName;
    }

    private BufferedReader input;
    private OutputStream output;
    private static final int TIME_OUT = 2000;
    private static final int DATA_RATE = 9600;
    private String inputLine;

    
    
    public void initialize() {
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            if (namePort.equals(currPortId.getName())) {
                portId = currPortId;
                break;
            }
        }
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            // abrir el puerto serial
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // estableser los parametros del puerto
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // abrir streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
            serialPort.disableReceiveTimeout();
			serialPort.enableReceiveThreshold(1);
			System.out.println("init serial");
			
        } catch (PortInUseException | UnsupportedCommOperationException | IOException | TooManyListenersException e) {
            System.err.println(e.toString());
        }
        try {
			Thread.sleep(1000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        //send("128");
    }

    public void send(String data) {
        try {
            output.write(data.getBytes());
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public String read() {
        return inputLine;
    }

    public void sleep(int time) throws Exception{
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.err.println(e.toString());
        }
    }

    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    @Override
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
            	//reciviendo datos del arduino
                inputLine = input.readLine();                
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }  
    }
}