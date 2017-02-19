package com.test.SpringBootTestProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.SpringBootTestProject.domain.User;

@Component
public class InjectedServiceClass {
	
	@Autowired
	ServiceProvider serviceProvider;
	
	public List<User> getUserDetails(){
		System.out.println("inside rest controller");
		return this.serviceProvider.getDetails();
	}
	
	public User getUserById(String id)
	{
		return this.serviceProvider.getDetailById(id);
	}
	
	public User getUserByName(String name)
	{
		return this.serviceProvider.getDetailByName(name);
	}
	

}
