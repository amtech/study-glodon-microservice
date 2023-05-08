package com.microservice.gldorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GldOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GldOrderApplication.class, args);
    }

}
