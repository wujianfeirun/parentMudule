package com.main.cousul;

import com.ecwid.consul.transport.TransportException;
import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.acl.model.NewAcl;
import com.ecwid.consul.v1.acl.model.UpdateAcl;
import com.ecwid.consul.v1.agent.model.NewCheck;
import com.ecwid.consul.v1.agent.model.NewService;
import com.ecwid.consul.v1.event.model.EventParams;
import com.ecwid.consul.v1.health.model.Check;
import com.ecwid.consul.v1.kv.model.PutParams;
import com.ecwid.consul.v1.session.model.NewSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by asus on 2017/5/19.
 */
public class ConsulDiscovery implements Runnable {
    private static ConsulDiscovery instance = new ConsulDiscovery();
    private static ScheduledExecutorService scheduler;
    private static String consulHost;
    private static boolean consulEnabled;
    private static ConsulClient consulClient;
    private static String KeyPrefix;

    private static Map discoryMap;
    private boolean isServiceRegisted;

    private ConsulDiscovery() {
    }

    public static synchronized ConsulDiscovery getInstance() {
        if (instance != null) {
            consulClient = new ConsulClient("192.168.1.102", 8500);
            return instance;
        } else {
            return new ConsulDiscovery();
        }
    }

    public static void main(String[] args) {
        ConsulDiscovery consulDiscovery = ConsulDiscovery.getInstance();
/*        Response<Acl> response = consulClient.getAcl("centraltracetoken");
        Acl acl =response.getValue();
        System.out.println(acl.getCreateIndex());
        System.out.println(acl.getType());*/
        //    new Thread(consulDiscovery).start();
        //  consulClient.agentJoin("192.168.1.101",true);


        //    System.out.println(consulClient.getStatusLeader().getValue());
/*        NewSession newSession = new NewSession();
        newSession.setNode("node101");
        newSession.setBehavior(Session.Behavior.RELEASE);
        consulClient.sessionCreate(newSession,new QueryParams("tpstrace")) ;
        consulClient.sessionDestroy("node101",new QueryParams("tpstrace"));*/

/*       List<Session> sessions =  consulClient.getSessionNode("node101",new QueryParams("tpstrace")).getValue();
        System.out.println(sessions.size());
        for (int i = 0; i < sessions.size(); i++) {
            System.out.println(sessions.get(i).getBehavior());
            System.out.println(sessions.get(i).getChecks());
            System.out.println(sessions.get(i).getName());
            System.out.println(sessions.get(i).getTtl());
            System.out.println(sessions.get(i).getId());
            System.out.println(sessions.get(i).getCreateIndex());
            System.out.println(sessions.get(i).getLockDelay());

        }*/

//        System.out.println(consulClient.getHealthChecksState(Check.CheckStatus.PASSING, new QueryParams("tpstrace")).getValue().get(1).);
        PutParams putParams = new PutParams();
/*        putParams.setFlags(1l);      //0
        putParams.setCas(0l);*/
        consulClient.setKVValue("key/test", "value-1", "centraltracetoken", putParams, new QueryParams("tpstrace"));
        // consulClient.setKVValue("key/test", "value-1",  new QueryParams("tpstrace"));
        //consulClient.setKVValue("test","value-1","centraltracetoken",new QueryParams("tpstrace"));
/*        consulClient.deleteKVValue("key","centraltracetoken",new QueryParams("tpstrace"));
        consulClient.deleteKVValues("key","centraltracetoken",new QueryParams("tpstrace"));
        consulClient.getKVValue("key","centraltracetoken",new QueryParams("tpstrace"));
        consulClient.getKVValues("key","centraltracetoken",new QueryParams("tpstrace"));*/

    }

    public void testlist() {
        //cluster useless
        consulClient.agentJoin("192.168.1.101", true);
        consulClient.agentForceLeave("node102");
        consulClient.getStatusLeader();            //serverStr-->  ip:host
        //nodes  useless
        consulClient.getNodes(new QueryParams("tpstrace"));
        consulClient.getCatalogNodes(new QueryParams("tpstrace"));

        //session
        consulClient.getSessionNode("node101", new QueryParams("tpstrace"));
        consulClient.sessionCreate(new NewSession(), new QueryParams("tpstrace"));
        consulClient.sessionDestroy("session", new QueryParams("tpstrace"));
        consulClient.getSessionList(new QueryParams("tpstrace"));
        consulClient.renewSession("session", new QueryParams("tpstrace"));


        //services    regist a service
        consulClient.agentServiceRegister(new NewService(), "token");
        consulClient.agentServiceDeregister("checkid");
        consulClient.getAgentServices();
        consulClient.getCatalogService("traceDBloader", new QueryParams("tpstrace"));

        //check  check service. set the status to pass. fail  warn....
        consulClient.agentCheckRegister(new NewCheck(), "token");
        consulClient.agentCheckPass("");
        consulClient.agentCheckFail("");
        consulClient.agentCheckWarn("");
        consulClient.agentCheckDeregister("checkid");
        //health
        consulClient.getHealthChecksForNode("node101", new QueryParams("tpstrace"));
        consulClient.getHealthChecksState(Check.CheckStatus.PASSING, new QueryParams("tpstrace"));
        consulClient.getHealthServices("traceDBloader", "tag", true, new QueryParams("tpstrace"));  //only pass
        //KV
        consulClient.deleteKVValue("key", "token", new QueryParams("tpstrace"));
        consulClient.deleteKVValues("key", "token", new QueryParams("tpstrace"));
        consulClient.getKVValue("key", "token", new QueryParams("tpstrace"));
        consulClient.getKVValues("key", "token", new QueryParams("tpstrace"));
        consulClient.setKVValue("key", "value", "token", new PutParams(), new QueryParams("tpstrace"));


        //event
        consulClient.eventFire("event", "payload", new EventParams(), new QueryParams("tpstrace"));
        consulClient.eventList(new QueryParams("tpstrace"));
        consulClient.eventList("event", new QueryParams("tpstrace"));

        //Acl
        consulClient.aclClone("id", "token");
        consulClient.aclCreate(new NewAcl(), "token");
        consulClient.aclDestroy("id", "token");
        consulClient.aclUpdate(new UpdateAcl(), "token");
        consulClient.getAclList("token");


    }


    public void run() {
        while (true) {
            System.out.println("discorver running");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

/*    private List<HealthService> getHealthServices(){

    }*/

    private boolean registerServiceInConsul(ConsulClient consulClient) {
        try {
            isServiceRegisted = true;
            consulClient.agentServiceRegister(createNewService(createServiceId()));
            return true;
        } catch (TransportException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isServiceRegisterdInConsul() {
        return isServiceRegisted;
    }


    private String createServiceId() {
        return "traceDbLoader-" + "trace-ua-" + "7300-" + "tpsps3u";
    }

    private String getTtlCheckId() {
        return "service:" + createServiceId();
    }

    private NewService createNewService(String serviceId) {
        NewService newService = new NewService();
        newService.setId(serviceId);
        newService.setName("traceDbLoader");
        newService.setAddress("tpsps3u");

        List<String> tags = new ArrayList<String>();
        tags.addAll(Arrays.asList("Env=ua", "JmxPort=7300", "ServiceName=traceDbLoader", "User=gfitps"));
        newService.setTags(tags);
        newService.setPort(8500);
        newService.setCheck(createTtlCheck(5000, "2m"));
        return newService;
    }


    private NewService.Check createTtlCheck(int peroidMs, String deregisterCriticalService) {
        NewService.Check ttlCheck = new NewService.Check();
        ttlCheck.setTtl(String.format("%dms", peroidMs));
        ttlCheck.setInterval("5000ms");
        ttlCheck.setTimeout("10000ms");
        ttlCheck.setDeregisterCriticalServiceAfter(deregisterCriticalService);
        return ttlCheck;
    }

}
