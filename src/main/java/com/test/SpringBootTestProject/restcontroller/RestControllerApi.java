package com.test.SpringBootTestProject.restcontroller;

import org.springframework.web.bind.annotation.RestController;

import com.test.SpringBootTestProject.Service.ServiceProvider;
import com.test.SpringBootTestProject.domain.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class RestControllerApi {
	
	@Autowired
	ServiceProvider serviceProvider;
	
	@RequestMapping(value="/getDetails", method=RequestMethod.GET)
	public List<User> getUserDetails(){
		System.out.println("inside rest controller");
		return this.serviceProvider.getDetails();
	}
	@RequestMapping(value="/getDetailsById/{id}", method=RequestMethod.GET)
	public User getUserById(@PathVariable String id)
	{
		return this.serviceProvider.getDetailById(id);
	}
	@RequestMapping(value="/getDetailsByName/{name}", method=RequestMethod.GET)
	public User getUserByName(@PathVariable String name)
	{
		return this.serviceProvider.getDetailByName(name);
	}

}
