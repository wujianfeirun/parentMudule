package com.main.CommandChain;

import org.apache.commons.chain.impl.ChainBase;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by asus on 2017/1/8.
 */
public class ChainExecute extends ChainBase {
    public ChainExecute() {
        addCommand(new Command1());
        addCommand(new Command2());
        addCommand(new Command3());
    }

    public static void main(String[] args) throws Exception {
/*        ChainExecute process = new ChainExecute();
        Context ctx= new ContextBase();
        process.execute( ctx);*/
        String str = "2017112T000000.000-0500";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ");
        Date date = sdf.parse(str);
        System.out.println(date);
    }

}
