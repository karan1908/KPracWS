package com.mkyong.ws;
 
import javax.xml.ws.Endpoint;
import com.mkyong.ws.HelloWorldImpl;
 
//Endpoint publisher
public class HelloWorldPublisher{
 
	public static void main(String[] args) {
	   Endpoint.publish("http://192.168.21.55:2244/ws/hello", new HelloWorldImpl());
    }
 
}