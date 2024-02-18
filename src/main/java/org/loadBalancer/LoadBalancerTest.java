package org.loadBalancer;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LoadBalancerTest {

    @Test
    public void testRegisterInstance() {
        LoadBalancer loadBalancer = new LoadBalancer(null);

        String instance1 = "12.34";
        String instance2 = "12.35";
        loadBalancer.registerInstance(instance1);
        loadBalancer.registerInstance(instance2);
        assertEquals(loadBalancer.getTotalInstances(),2);
    }

    @Test
    public void testRandomGetInstance() {
        LoadBalancer loadBalancer = new LoadBalancer(new RandomInstanceStrategy());
        loadBalancer.registerInstance("first instance");
        loadBalancer.registerInstance("second instance");
        String instance = loadBalancer.getInstance();
        assertNotNull(instance);
    }
    @Test
    public void testRoundRobinGetInstance() {
        LoadBalancer loadBalancer = new LoadBalancer(new RoundRobinStrategy());
        loadBalancer.registerInstance("first instance");
        loadBalancer.registerInstance("second instance");
        String instance1 = loadBalancer.getInstance();
        assertEquals(instance1,"first instance");
        String instance2 = loadBalancer.getInstance();
        assertEquals(instance2,"second instance");
    }

}
