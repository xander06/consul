package com.kruger.springcloud.msvc.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class MsvcCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcCursosApplication.class, args);
	}

}
