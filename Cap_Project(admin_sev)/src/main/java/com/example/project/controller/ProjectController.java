package com.example.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.exception.ResourceNotFoundException;
import com.example.project.model.Project;
import com.example.project.repository.ProjectRepository;

@RestController
@RequestMapping("/projects")
public class ProjectController 
{	
	Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectRepository project_repo;
	
	@GetMapping
	public List<Project> getAllProject()
	{
		logger.debug("Sucessfully you featched all the Project details");
		System.out.println();
		return project_repo.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Project> getProjectById(@PathVariable int id)
	{
		logger.debug("Sucessfully you got the Project details by id");
		System.out.println();
		
		Project proj = project_repo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Project not found with id:"+id));
		return ResponseEntity.ok(proj);
	}
	
	@PostMapping
	public Project addProject(@RequestBody Project proj)
	{
		logger.debug("New project added sucessfully");
		System.out.println();
		
		return project_repo.save(proj);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable int id, @RequestBody Project proj)
	{
		logger.debug("Sucessfully you updated the project details");
		System.out.println();
		
		Project updateProject = project_repo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Project not exist with id:"+id));
		
		updateProject.setProject_name(proj.getProject_name());
		updateProject.setProject_description(proj.getProject_description());
		updateProject.setStart_date(proj.getStart_date());
		updateProject.setEnd_date(proj.getEnd_date());
		
		project_repo.save(updateProject);
		
		return ResponseEntity.ok(updateProject);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Project> deleteProject(@PathVariable int id)
	{
		logger.debug("project has been deleted sucessfuly");
		System.out.println();
		
		Project proj = project_repo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Project not exist with id:"+id));
		project_repo.delete(proj);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}