
without authenticate>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
JmxBeanContain1的jvm参数：
-Dcom.sun.management.jmxremote.port=1099
-Dcom.sun.management.jmxremote.authenticate=false
-Dcom.sun.management.jmxremote.ssl=false

stub 默认为jmxrmi

RemoteInvoke连接字符串：service:jmx:rmi://localhost/jndi/rmi://localhost:1099/jmxrmi


with authenticate>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
JmxBeanContain1的jvm参数：
-Dcom.sun.management.jmxremote.port=1099
-Dcom.sun.management.jmxremote.authenticate=true
-Dcom.sun.management.jmxremote.ssl=false
-Dcom.sun.management.jmxremote.password.file=D:/jmx.access

RemoteInvoke1连接字符串：service:jmx:rmi://localhost/jndi/rmi://localhost:1099/jmxrmi


运行期传输的参数等价于spring中配置connectserver或者如下代码：>>>>>>>
MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer()。
LocateRegistry.createRegistry(6000);
JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(url, env, beanServer);   //env 进行权限控制
cs.start();

