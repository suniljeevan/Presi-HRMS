package com.example.lms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lms.entity.LeaveDetails;
import com.example.lms.repository.LeaveManageRepository;

@RestController
@RequestMapping("/leaves")
public class LeaveManagementController 
{
	Logger logger = LoggerFactory.getLogger(LeaveManagementController.class);
	
	@Autowired
	private LeaveManageRepository leaveManageRepo;
	
	@PostMapping
	public LeaveDetails addLeave(@RequestBody LeaveDetails leave) 
	{
		logger.debug("Your Leave sent sucessfully");
		System.out.println();
		return leaveManageRepo.save(leave);
	}
	
	@GetMapping
	public List<LeaveDetails> getallLeaves()
	{
		logger.debug("Sucessfully u featched all the leave details");
		System.out.println();
		return leaveManageRepo.findAll();
	}
}
