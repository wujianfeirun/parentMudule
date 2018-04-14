package com.main.jmx.JMX203_Spring_Params_Port;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

/**
 * Created by asus on 2016/12/1.
 */
public class RemoteInvoke {
    public static void main(String[] args) throws IOException, MalformedObjectNameException {
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi://localhost/jndi/rmi://localhost:1099/myconnector");
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
        IJmxTestBean testBean = JMX.newMBeanProxy(mbsc, new ObjectName("bean:name=testBean1"), IJmxTestBean.class);
        testBean.setAge(5);
    }
}
