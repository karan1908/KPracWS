package com.client.servlet;

import java.io.IOException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejb.component.Greeter;

public class EJBClientServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String result =  "Not known!";	
		result = invokeOnBean();
		req.setAttribute("bean.result",result);
		req.getRequestDispatcher("/displayResult.jsp").forward(req,resp);
	
	}
	
	public String invokeOnBean() {
		String greeting="Error";
        try {
            final Hashtable props = new Hashtable();
            // setup the ejb: namespace URL factory
            props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            // create the InitialContext
            final Context context = new javax.naming.InitialContext(props);
            
            System.out.println("context "+context);
    		final String appName = "";
    		final String moduleName = "EJBComponentDestinationWeb";
    		final String distinctName = "";
    		final String beanName = "GreeterBean";
    		final String viewClassName = Greeter.class.getName();
    		String jndi = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
    		final Greeter bean = (Greeter) context.lookup(jndi);
 
            // invoke on the bean
            greeting = bean.greet("Karan");
 
            System.out.println("Received greeting: " + greeting);
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        return greeting;
  }//invokeOnBean

}
