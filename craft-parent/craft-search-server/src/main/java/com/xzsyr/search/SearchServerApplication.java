package com.xzsyr.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


/**        
 * Title: SearchApplication.java    
 * Description: 搜索微服务
 * @author jizhuang.wang       
 * @created 2018年6月24日08:09:43    
 */ 
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
@RefreshScope 
public class SearchServerApplication {
	public static void main(String[] args) {
        SpringApplication.run(SearchServerApplication.class, args);
    }
}