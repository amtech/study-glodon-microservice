package com.microservice.gldorder.controller;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 第一种方式, 通过loadBalancerClient选择服务, 继而通过RestTemplate执行请求,获取数据.
     * @param id
     * @return
     */
    @GetMapping("/findProduct/{id}")
    public String findProduct(@PathVariable Integer id){
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s/product/%s", serviceInstance.getHost(), serviceInstance.getPort(),
                id + 1);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(URI.create(url), String.class);
    }

    /**
     * 微服务第二种方式,也是当今最常用的方式, 通过OpenFeign操作.
     */


}
