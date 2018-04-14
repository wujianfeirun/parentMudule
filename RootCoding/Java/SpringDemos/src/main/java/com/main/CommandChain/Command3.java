package com.main.CommandChain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;


public class Command3 implements Command {

    @Override
    public boolean execute(Context context) throws Exception {
        System.out.println("Command3 is done!");
        return false;
    }
}