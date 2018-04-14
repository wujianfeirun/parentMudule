package com.main.jmx.JMX204_Spring_Params_Port_In_Jvm;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 2016/12/1.
 */
public class RemoteInvoke1 {
    public static void main(String[] args) throws IOException, MalformedObjectNameException {
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi://localhost/jndi/rmi://localhost:1099/jmxrmi");
        Map<String, String[]> env = new HashMap<String, String[]>();
        String[] userpasswd = {"www", "123"};
        env.put(JMXConnector.CREDENTIALS, userpasswd);
        JMXConnector jmxc = JMXConnectorFactory.connect(url, env);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
        IJmxTestBean testBean = JMX.newMBeanProxy(mbsc, new ObjectName("bean:name=testBean1"), IJmxTestBean.class);
        testBean.setAge(5);
    }
}
