package com.yhy.cloud.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaAppliction {

	public static void main(String[] args) {
		SpringApplication.run(EurekaAppliction.class, args);
	}
}
