package com.main.jmx.JMX001_RMI;

import java.rmi.RemoteException;

public interface Hello extends java.rmi.Remote {
    String sayHello() throws RemoteException;
}
