package org.loadBalancer;

import java.util.ArrayList;
import java.util.List;

public interface LoadBalancingStrategy {
    public String getInstance(List<String> list);
}
