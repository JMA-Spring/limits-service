package com.jesus.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	@Value("${limits-service.message}")
	private String message;
	
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromCnfiguration() {
		System.out.println(message);
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}

}
