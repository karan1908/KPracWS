package com.mkyong.ws;

import javax.xml.ws.Endpoint;
 
//Endpoint publisher
public class WsPublisher{
 
	public static void main(String[] args) {
	   Endpoint.publish("http://192.168.21.55:8181/ws/server", new ServerInfoImpl());
 
	   System.out.println("Service is published!");
    }
 
}