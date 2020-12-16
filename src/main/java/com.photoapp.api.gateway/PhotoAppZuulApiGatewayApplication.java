package com.photoapp.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class PhotoAppZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppZuulApiGatewayApplication.class, args);
	}

}
