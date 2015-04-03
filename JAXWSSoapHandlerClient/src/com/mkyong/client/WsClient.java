package com.mkyong.client;
 
import com.mkyong.ws.ServerInfo;
import com.mkyong.ws.ServerInfoImplService;
 
public class WsClient{
 
	public static void main(String[] args) throws Exception {
 
		ServerInfoImplService sis = new ServerInfoImplService();
		ServerInfo si = sis.getServerInfoImplPort();
 
		System.out.println(si.getServerName());
 
    }
 
}