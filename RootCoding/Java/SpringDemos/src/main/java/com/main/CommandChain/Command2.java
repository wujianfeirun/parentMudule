package com.main.CommandChain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;


public class Command2 implements Command {

    @Override
    public boolean execute(Context context) throws Exception {
        System.out.println("Command2 is done!");
        return false;
    }
}