package org.loadBalancer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomInstanceStrategy implements LoadBalancingStrategy{

    @Override
    public String getInstance(List<String> ipList) {
        Random random = new Random();
        try {
            int index = random.nextInt(ipList.size());
            return ipList.get(index);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
