package org.loadBalancer;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class RoundRobinStrategy implements LoadBalancingStrategy{

    private AtomicInteger currentIndex;
    private final ReentrantLock lock;

    public RoundRobinStrategy() {
        this.currentIndex = new AtomicInteger(0);
        lock = new ReentrantLock();
    }

    @Override
    public String getInstance(List<String> ipList) {
       String instance = null;
        try {
            lock.lock();
            int index = (currentIndex.getAndIncrement()) % ipList.size();
             instance = ipList.get(index);

        }
        catch (Exception e){
            System.err.println(e.getMessage());

        }
        finally {
            lock.unlock();
            return instance;
        }
    }
}
