package it.unitn.alic.ecommerceclient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.HashMap;
import java.util.Properties;

public class ServiceLocator {

    private static HashMap<String, Object> cache;

    static {
        cache = new HashMap<String, Object>();
    }

    public static Object getService(String jndiName) throws NamingException {

        Object service = cache.get(jndiName);

        if(service == null) {

            Properties jndiProperties = new Properties();
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
            jndiProperties.put(Context.PROVIDER_URL,"http-remoting://localhost:8090");
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            jndiProperties.put("jboss.naming.client.ejb.context", true);

            InitialContext ctx = new InitialContext(jndiProperties);

            service = ctx.lookup(jndiName);
            cache.put(jndiName, service);
        }
        System.out.println("Lookup of Facade EJB was successful");
        return service;
    }
}