package com.main.CommandChain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;


public class Command1 implements Command {

    @Override
    public boolean execute(Context context) throws Exception {
        System.out.println("Command1 is done!");
        return false;
    }
}