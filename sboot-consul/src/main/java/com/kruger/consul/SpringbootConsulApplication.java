package com.kruger.consul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class SpringbootConsulApplication {

	@Autowired
	ApplicationConfig applicationConfig;
	
	@GetMapping("/getDataMessage")
	private String getDataMessage() {
		return applicationConfig.getDataMessage();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootConsulApplication.class, args);
		
	}

}
