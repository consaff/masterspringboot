package com.example.demodocker;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import io.micrometer.prometheus.PrometheusMeterRegistry;
//import io.micrometer.prometheus.PrometheusConfig;


@RestController
public class DemoController
{
    
    @RequestMapping("/fakemetrics")
    public String test()
    {
        String jvm_buffer_memory_used_bytes = 
            "# HELP jvm_buffer_memory_used_bytes An estimate of the memory that the Java virtual machine is using for this buffer pool\n"
            + "# TYPE jvm_buffer_memory_used_bytes gauge\n"
            + "jvm_buffer_memory_used_bytes{id=\"direct\"} 81920.0\n";
        
        String jvm_memory_max_bytes =
            "# HELP jvm_memory_max_bytes The maximum amount of memory in bytes that can be used for memory management\n"
            + "# TYPE jvm_memory_max_bytes gauge\n"
            + "jvm_memory_max_bytes{area=\"heap\", id=\"PS Survivor Space\"} 2097152.0\n"
            + "jvm_memory_max_bytes{area=\"heap\", id=\"PS Old Gen\"} 5.54067E9\n"
            + "jvm_memory_max_bytes{area=\"heap\", id=\"PS EdenSpace\"} 2.2734E9\n";
        
        return jvm_buffer_memory_used_bytes + jvm_memory_max_bytes + "# EOF\n";       
    }
    
    //PrometheusMeterRegistry prometheusRegistry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
    @RequestMapping("/")
    public List<Customer> findAll()
    {
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(new Customer(1, "frank"));
        customerList.add(new Customer(2, "john"));
        return customerList;
    }
    
    /*
    public Object GetPrometheusMetrics()
    {
        System.out.println("metrics has been called!");
        Object response = prometheusRegistry.scrape();
        System.out.println("RESPONSE: " + response);
        return response;
    }
    */
}
