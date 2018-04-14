package com.main.jmx.JMX003_JmxNotification;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class Jack extends NotificationBroadcasterSupport implements JackMBean {
    private int seq = 0;

    public void hi() {
        //创建一个信息包；    //给这个Notification起个名称   //由谁发出的Notification  //一系列通知中的序列号,可以设任意数值 //发出时间
        Notification n = new Notification("jack.hi", this, ++seq, System.currentTimeMillis(), "Jack");//发出的消息文本
        //发出去
        sendNotification(n);
    }
}
