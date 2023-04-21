package com.example.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.emp.controller.EmployeeController;

@SpringBootApplication
@EnableEurekaServer
public class EmpregistrationApplication
{
	public static void main(String[] args) 
	{
		Logger logger = LoggerFactory.getLogger(EmployeeController.class);
		
		SpringApplication.run(EmpregistrationApplication.class, args);
		logger.info("This is info message from Main class");
		logger.warn("This is warn message from Main class");
		logger.error("This is error message from Main class");
		logger.debug("This is debug message from Main class");
		logger.trace("This is trace message from Main class");
		
		logger.info("Hello User \n Application starts now...");
	}
}
