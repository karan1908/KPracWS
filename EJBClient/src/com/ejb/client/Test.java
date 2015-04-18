package com.ejb.client;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ejb.component.AdderImplRemote;
import com.ejb.component.CounterBeanRemote;
import com.ejb.component.IncrementerBeanRemote;


public class Test {

	public static void main(String[] args) throws Exception {
		try
		{
			// Invoke a stateless bean
			//invokeStatelessBean();

			// Invoke a stateful bean
			//invokeStatefulBean();

			invokeIncrementerStatelessBean();
			
		}
		catch(Exception e)
		{

			e.printStackTrace();
		}
	}

	/**
	 * Looks up a stateless bean and invokes on it
	 *
	 * @throws NamingException
	 */
	private static void invokeStatelessBean() throws NamingException {
		// Let's lookup the remote stateless calculator
		final AdderImplRemote statelessAdderImplRemote = lookupRemoteStatelessCalculator();
		System.out.println("Obtained a remote stateless calculator for invocation");
		// invoke on the remote calculator
		int a = 204;
		int b = 340;
		System.out.println("Adding " + a + " and " + b + " via the remote stateless calculator deployed on the server");
		int sum = statelessAdderImplRemote.add(a, b);
		System.out.println("Remote calculator returned sum = " + sum);
		if (sum != a + b) {
			throw new RuntimeException("Remote stateless calculator returned an incorrect sum " + sum + " ,expected sum was " + (a + b));
		}

	}



	/**
	 * Looks up and returns the proxy to remote stateless calculator bean
	 *
	 * @return
	 * @throws NamingException
	 */
	private static AdderImplRemote lookupRemoteStatelessCalculator() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

		final Context context = new InitialContext(jndiProperties);

		// The app name is the application name of the deployed EJBs. This is typically the ear name
		// without the .ear suffix. However, the application name could be overridden in the application.xml of the
		// EJB deployment on the server.
		// Since we haven't deployed the application as a .ear, the app name for us will be an empty string
		final String appName = "";
		// This is the module name of the deployed EJBs on the server. This is typically the jar name of the
		// EJB deployment, without the .jar suffix, but can be overridden via the ejb-jar.xml
		// In this example, we have deployed the EJBs in a jboss-as-ejb-remote-app.jar, so the module name is
		// jboss-as-ejb-remote-app
		final String moduleName = "EJBComponent";
		// AS7 allows each deployment to have an (optional) distinct name. We haven't specified a distinct name for
		// our EJB deployment, so this is an empty string
		final String distinctName = "";
		// The EJB name which by default is the simple class name of the bean implementation class
		final String beanName = "AdderImpl";
		// the remote view fully qualified class name
		final String viewClassName = AdderImplRemote.class.getName();
		// let's do the lookup

		String jndi = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;

		return (AdderImplRemote) context.lookup(jndi);
	}


	/**
	 * Looks up a stateful bean and invokes on it
	 *
	 * @throws NamingException
	 */
	private static void invokeStatefulBean() throws NamingException {
		// Let's lookup the remote stateful counter
		final CounterBeanRemote statefulRemoteCounter = lookupRemoteStatefulCounter();
		final CounterBeanRemote st = lookupRemoteStatefulCounter();
		System.out.println("Obtained a remote stateful counter for invocation");
		// invoke on the remote counter bean
		final int NUM_TIMES = 20;
		System.out.println("Counter will now be incremented " + NUM_TIMES + " times");
		for (int i = 0; i < NUM_TIMES; i++) {
			System.out.println("Incrementing counter");
			statefulRemoteCounter.increment();
			
			System.out.println("Count is " + st.getCount());
			
			System.out.println("Count after increment is " + statefulRemoteCounter.getCount());
		}
		// now decrementing
		/*System.out.println("Counter will now be decremented " + NUM_TIMES + " times");
		for (int i = NUM_TIMES; i > 0; i--) {
			System.out.println("Decrementing counter");
			statefulRemoteCounter.decrement();
			System.out.println("Count after decrement is " + statefulRemoteCounter.getCount());
		}*/
		
	}

	/**
	 * Looks up and returns the proxy to remote stateful counter bean
	 *
	 * @return
	 * @throws NamingException
	 */
	private static CounterBeanRemote lookupRemoteStatefulCounter() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);
		// The app name is the application name of the deployed EJBs. This is typically the ear name
		// without the .ear suffix. However, the application name could be overridden in the application.xml of the
		// EJB deployment on the server.
		// Since we haven't deployed the application as a .ear, the app name for us will be an empty string
		final String appName = "";
		// This is the module name of the deployed EJBs on the server. This is typically the jar name of the
		// EJB deployment, without the .jar suffix, but can be overridden via the ejb-jar.xml
		// In this example, we have deployed the EJBs in a jboss-as-ejb-remote-app.jar, so the module name is
		// jboss-as-ejb-remote-app
		final String moduleName = "EJBComponent";
		// AS7 allows each deployment to have an (optional) distinct name. We haven't specified a distinct name for
		// our EJB deployment, so this is an empty string
		final String distinctName = "";
		// The EJB name which by default is the simple class name of the bean implementation class
		final String beanName = "CounterBean";
		// the remote view fully qualified class name
		final String viewClassName = CounterBeanRemote.class.getName();
		// let's do the lookup (notice the ?stateful string as the last part of the jndi name for stateful bean lookup)
		return (CounterBeanRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName + "?stateful");
	}


	private static void invokeIncrementerStatelessBean() throws NamingException {
		// Let's lookup the remote stateful counter
		final IncrementerBeanRemote statelessRemoteCounter = lookupRemoteIncrementerStatelessCounter();
		final int NUM_TIMES = 5;
		System.out.println("Counter will now be incremented " + NUM_TIMES + " times");
		for (int i = 0; i < NUM_TIMES; i++) {
			
			IncrementerBeanRemote st = lookupRemoteIncrementerStatelessCounter();	
			System.out.println("Count is " + st.getCount());
			
			System.out.println("Incrementing counter");
			statelessRemoteCounter.increment();
			System.out.println("Count after increment is " + statelessRemoteCounter.getCount());
		}
		for (int i = NUM_TIMES; i > 0; i--) {
			System.out.println("Decrementing counter");
			statelessRemoteCounter.decrement();
			System.out.println("Count after decrement is " + statelessRemoteCounter.getCount());
		}
	}


	private static IncrementerBeanRemote lookupRemoteIncrementerStatelessCounter() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);
		System.out.println("context "+context);
		final String appName = "";
		final String moduleName = "EJBComponent";
		final String distinctName = "";
		final String beanName = "IncrementerBean";
		final String viewClassName = IncrementerBeanRemote.class.getName();
		String jndi = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
		return (IncrementerBeanRemote) context.lookup(jndi);
	}
	

}//Test
