package com.main._06LockDegrade;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Degrade {
    private Map<String, Object> map = new HashMap<>();

    private ReadWriteLock rwl = new ReentrantReadWriteLock() ;
    private Lock r = rwl.readLock();
    private Lock w = rwl.writeLock();
    private volatile boolean isUpdate;

    public void readWrite(){
        r.lock();
        if(isUpdate){
            r.unlock();
            //锁降级， 在写锁没有释放时获取读锁，然后释放写锁，等读操作完成之后才释放读锁，  保证写之后的读操作不会被别的写操作扰乱
            w.lock();
            map.put("xxxx","xxxxx");
            r.lock();
            w.unlock();
        }

        Object obj = map.get("xxxx");
        System.out.println(obj);

        r.unlock();
    }

}
