package com.mkyong.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.HandlerChain;
 
//Service Endpoint Interface
@WebService
@HandlerChain(file="handler-chain.xml")
public interface ServerInfo{
 
	@WebMethod String getServerName();
 
}