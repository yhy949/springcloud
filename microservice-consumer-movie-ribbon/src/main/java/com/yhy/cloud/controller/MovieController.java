package com.yhy.cloud.controller;

import com.yhy.cloud.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    public User finById(@PathVariable Long id){
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/"+id,User.class);
    }
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @GetMapping("/test")
    public String test() {
        //使用随机
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
        //使用轮询方式
        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-provider-user2");
        System.out.println("222" + ":" + serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());
        return "1";
    }

}
