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
    
    @RequestMapping("/sleep")
    public String sleep() throws InterruptedException 
    {
        Thread.sleep(4000);
        return "sleep is complete!\n";
    }
    
    @RequestMapping("/fakemetrics")
    public String test()
    {
        
        //metrics for alert: SpringBootDemoJvmGc
        String jvm_gc_pause_seconds =
            "# HELP jvm_gc_pause_seconds time spent in GC pause\n"
            + "# TYPE jvm_gc_pause_seconds summary\n"
            + "jvm_gc_pause_seconds_count{cause=\"Metadata GC Threshold\"} 2.0\n"
            + "jvm_gc_pause_seconds_sum{cause=\"Metadata GC Threshold\"} .489\n"
            + "jvm_gc_pause_seconds_count{cause=\"Allocation Failure\"} 4.0\n"
            + "jvm_gc_pause_seconds_sum{cause=\"Allocation Failure\"} .932\n";
        
        //metrics for alert: SpringBootDemoJvmMemory
        String jvm_memory_used_bytes = 
            "# HELP jvm_memory_used_bytes An estimate of the memory that the Java virtual machine is using for this pool\n"
            + "# TYPE jvm_memory_used_bytes gauge\n"
            + "jvm_memory_used_bytes{area=\"heap\", id=\"PS Survivor Space\"} 81920.0\n";
        
        String jvm_memory_max_bytes =
            "# HELP jvm_memory_max_bytes The maximum amount of memory in bytes that can be used for memory management\n"
            + "# TYPE jvm_memory_max_bytes gauge\n"
            + "jvm_memory_max_bytes{area=\"heap\",id=\"PS Survivor Space\"} 41504.2\n"
            + "jvm_memory_max_bytes{area=\"heap\",id=\"PS Old Gen\"} 12310.5\n"
            + "jvm_memory_max_bytes{area=\"heap\",id=\"PS EdenSpace\"} 37854.4\n"
            + "jvm_memory_max_bytes{area=\"nonheap\"} 994399.1\n";
        
        //metrics for alert: SpringBootDemoProcessRestarts
        String process_uptime_seconds =
            "# HELP process_uptime_seconds The uptime of the JVM\n"
            + "# TYPE process_uptime_seconds gauge\n"
            + "process_uptime_seconds 44\n";
        
        //metrics for alert: SpringBootDemoProcessTime
        String http_server_requests_seconds_max =
            "# HELP http_server_requests_seconds_max time to complete an HTTP server request\n"
            + "# TYPE http_server_requests_seconds_max gauge\n"
            + "http_server_requests_seconds_max{exception=\"None\",outcome=\"SUCCESS\"} 11.0\n";
        
        //metrics for alert: SpringBootDemoRequestErrors
        String http_server_requests_seconds =
            "# HELP http_server_requests_seconds summary of HTTP server requests\n"
            + "# TYPE http_server_requests_seconds summary\n"
            + "http_server_requests_seconds_sum{exception=\"None\",method=\"GET\",status=\"200\"} 54\n"
            + "http_server_requests_seconds_count{exception=\"None\",method=\"GET\",status=\"200\"} 4\n"
            + "http_server_requests_seconds_count{exception=\"None\",method=\"GET\",outcome=\"CLIENT_ERROR\",status=\"501\"} 2\n"
            + "http_server_requests_seconds_max{exception=\"None\",method=\"GET\",outcome=\"CLIENT_ERROR\",status=\"501\"} 5\n";
       
            
        
        return jvm_gc_pause_seconds + jvm_memory_used_bytes + jvm_memory_max_bytes + process_uptime_seconds
            + http_server_requests_seconds_max + http_server_requests_seconds + "# EOF\n";       
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
    
}
