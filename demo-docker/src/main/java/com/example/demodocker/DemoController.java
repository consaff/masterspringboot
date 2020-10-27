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
            + "jvm_memory_max_bytes{area=\"heap\",id=\"PS Survivor Space\"} 2097152.0\n"
            + "jvm_memory_max_bytes{area=\"heap\",id=\"PS Old Gen\"} 5.54067E9\n"
            + "jvm_memory_max_bytes{area=\"heap\",id=\"PS EdenSpace\"} 2.2734E9\n";
        
        String http_server_requests_seconds_max =
            "# HELP http_server_requests_seconds_max time to complete an HTTP server request\n"
            + "# TYPE http_server_requests_seconds_max gauge\n"
            + "http_server_requests_seconds_max{exception=\"None\",method=\"GET\",outcome=\"SUCCESS\",status=\"200\"} 4.0\n";
        
        String http_server_requests_seconds =
            "# HELP http_server_requests_seconds summary of HTTP server requests\n"
            + "# TYPE http_server_requests_seconds summary\n"
            + "http_server_requests_seconds_count{exception=\"None\",method=\"GET\",outcome=\"CLIENT_ERROR\",status=\"500\"} 1345\n"
            + "http_server_requests_seconds_max{exception=\"None\",method=\"GET\",outcome=\"CLIENT_ERROR\",status=\"500\"} 9384\n";
       
        String process_uptime_seconds =
            "# HELP process_uptime_seconds The uptime of the JVM\n"
            + "# TYPE process_uptime_seconds gauge\n"
            + "process_uptime_seconds 23456.3456\n";
        
        String jvm_gc_memory_promoted_bytes_total = 
            "# HELP jvm_gc_memory_promoted_bytes_total memory used in the JVM GC\n"
            + "# TYPE jvm_gc_memory_promoted_bytes_total counter\n"
            + "jvm_gc_memory_promoted_bytes_total 654659.4\n";
        
        String jvm_gc_memory_allocated_bytes_total =
            "# HELP jvm_gc_memory_allocated_bytes_total shows the size of the total GC\n"
            + "# TYPE jvm_gc_memory_allocated_bytes_total counter\n"
            + "jvm_gc_memory_allocated_bytes_total 4.5981234E10\n";
        
        String jvm_gc_max_data_size_bytes =
            "# HELP jvm_gc_max_data_size_bytes Max size of old generation pool\n"
            + "# TYPE jvm_gc_max_data_size_bytes gauge\n"
            + "jvm_gc_max_data_size_bytes 5.542945E9\n";
            
        
        return jvm_buffer_memory_used_bytes + jvm_memory_max_bytes + http_server_requests_seconds_max + 
            process_uptime_seconds + jvm_gc_memory_promoted_bytes_total + jvm_gc_memory_allocated_bytes_total + 
            http_server_requests_seconds + jvm_gc_max_data_size_bytes + "# EOF\n";       
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
