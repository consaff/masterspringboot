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
    
    @RequestMapping("/metrics")
    public String test()
    {
        String ret = 
        "# HELP jvm_memory_used_bytes The amount of used memory \n# TYPE jvm_memory_used_bytes gauge \njvm_memory_used_bytes{area="heap",id="PS Survivor Space",} 0.0" +
            "\njvm_memory_used_bytes{area="heap",id="PS Old Gen",} 1.1718296E7 \njvm_memory_used_bytes{area="heap",id="PS Eden Space",} 1.07929016E8" +
            "\njvm_memory_used_bytes{area="nonheap",id="Metaspace",} 3.9945752E7 \njvm_memory_used_bytes{area="nonheap",id="Code Cache",} 1.074304E7"
            + "\njvm_memory_used_bytes{area="nonheap",id="Compressed Class Space",} 4938248.0";
        
        return ret;       
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
