package com.mkyong.ws;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "com.mkyong.ws.ServerInfo")
public class ServerInfoImpl implements ServerInfo{

	@Override
	public String getServerName() {
		 
		return "mkyong server";
 
	}

}