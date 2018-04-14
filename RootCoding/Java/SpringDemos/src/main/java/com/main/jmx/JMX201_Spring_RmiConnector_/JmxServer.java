package com.main.jmx.JMX201_Spring_RmiConnector_;

import javax.management.MBeanServer;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;

/**
 * Created by asus on 2016/11/30.
 */
public class JmxServer {
    public static void main(String[] args) throws IOException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        LocateRegistry.createRegistry(1099);
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
        JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);
        cs.start();
    }
}
