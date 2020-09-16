package com.example.demodocker;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.prometheus.PrometheusMeterRegistry;


@RestController
public class DemoController
{
    
    PrometheusMeterRegistry prometheusRegistry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
    @RequestMapping("/")
    public List<Customer> findAll()
    {
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(new Customer(1, "frank"));
        customerList.add(new Customer(2, "john"));
        return customerList;
    }
    
    @RequestMapping("/metrics")
    public Object GetPrometheusMetrics()
    {
        System.out.println("metrics has been called!");
        Object response = prometheusRegistry.scrape();
        System.out.println("RESPONSE: " + response);
        return response;
    }
}
