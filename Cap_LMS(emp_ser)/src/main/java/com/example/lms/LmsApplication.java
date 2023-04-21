package com.example.lms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import com.example.lms.controller.LeaveManagementController;

@SpringBootApplication
@EnableEurekaServer
public class LmsApplication 
{

	public static void main(String[] args) 
	{
		Logger logger = LoggerFactory.getLogger(LeaveManagementController.class);
		SpringApplication.run(LmsApplication.class, args);
		
		logger.info("This is info message from Main class");
		logger.warn("This is warn message from Main class");
		logger.error("This is error message from Main class");
		logger.debug("This is debug message from Main class");
		logger.trace("This is trace message from Main class");
		
		logger.info("Hello User \n Application starts now...");

	}
}
