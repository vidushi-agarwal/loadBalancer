package org.loadBalancer;

import java.util.*;

public class LoadBalancer {
    List<String> ipList;
    private static  final int TOTAL_INSTANCES = 10;

    LoadBalancingStrategy loadBalancingStrategy;

    public LoadBalancer(LoadBalancingStrategy loadBalancingStrategy){
        ipList = new ArrayList<>();
        this.loadBalancingStrategy = loadBalancingStrategy;
    }

    public synchronized boolean  registerInstance(String instance) {
        try {
            if( ipList.size()==TOTAL_INSTANCES) {
                throw new Exception("Load Balancer is out of capacity");

            }
            else if (ipList.contains(instance)) {
                throw new Exception("Instance "+instance+"is already registered");
            }
            else {
                ipList.add(instance);
                return true;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return  false;
        }

    }

    public int getTotalInstances(){
        return ipList.size();
    }
    public String  getInstance(){
       return loadBalancingStrategy.getInstance(ipList);
    }
    public void removeInstance(String instance){
        ipList.remove(instance);
    }
}
