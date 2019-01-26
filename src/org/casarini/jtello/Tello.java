/**
 *  This file is part of jTello.
 *  
 *  Copyright © 2019 Paolo Casarini <paolo@casarini.org>
 *
 *  jTello is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  jTello is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with jTello.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.casarini.jtello;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class Tello {
    private static final String IPADDRESS = "192.168.10.1";
    private static final int PORT = 8889;
    private static final int BUFSIZE = 1024;
    
    private InetAddress ipAddress;
    private DatagramSocket socket;
    
    public void connect() throws IOException {
        socket = new DatagramSocket();
        ipAddress = InetAddress.getByName(IPADDRESS);
    }
    
    public void disconnect() {
        socket.close();
    }
    
    public void init() throws IOException {
        sendCommand("command");
    }
    
    public void takeOff() throws IOException {
        sendCommand("takeoff");
    }
    
    public void land() throws IOException {
        sendCommand("land");
    }
    
    public void up(int distance) throws IOException {
    	if (distance >= 20 || distance <= 500) {
    		sendCommand("up " + distance);
    	} else {
    		//TODO catch wrong input
    	}
    }
    
    public void down(int distance) throws IOException {
    	if (distance >= 20 || distance <= 500) {
    		sendCommand("down " + distance);
    	} else {
    		//TODO catch wrong input
    	}
    }
    
    public void left(int distance) throws IOException {
    	if (distance >= 20 || distance <= 500) {
    		sendCommand("left " + distance);
    	} else {
    		//TODO catch wrong input
    	}
    }
 
    public void right(int distance) throws IOException {
    	if (distance >= 20 || distance <= 500) {
    		sendCommand("right " + distance);
    	} else {
    		//TODO catch wrong input
    	}
    }
    
    public void forward(int distance) throws IOException {
    	if (distance >= 20 || distance <= 500) {
    		sendCommand("forward " + distance);
    	} else {
    		//TODO catch wrong input
    	}
    }
    
    public void back(int distance) throws IOException {
    	if (distance >= 20 || distance <= 500) {
    		sendCommand("back " + distance);
    	} else {
    		//TODO catch wrong input
    	}
    }
    
    public void rotate(int degrees) throws IOException {
        if (degrees > 0 && degrees <= 360) {
            sendCommand("cw " + degrees);
        } else if (degrees < 0 && degrees >= -360) {
            sendCommand("ccw " + (-degrees));
        } else {
        	//TODO catch wrong input
        }
    }
    
    public String sendCommand(String command) throws IOException {
        System.out.println(command);
        
        byte[] data = command.getBytes();
        DatagramPacket out = new DatagramPacket(data, data.length, ipAddress, PORT);
        socket.send(out);
        
        byte[] buffer = new byte[BUFSIZE];
        DatagramPacket in = new DatagramPacket(buffer, buffer.length);
        socket.receive(in);
        
        String response = new String(in.getData(), StandardCharsets.UTF_8);
        System.out.println(response);
       
        return response;
    }
}

