package com.test.SpringBootTestProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.SpringBootTestProject.domain.User;
import com.test.SpringBootTestProject.domain.UserRepository;

@Service
public class ServiceProvider {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getDetails()
	{	
		System.out.println("inside service method");
		List<User> userList=this.userRepository.findAll();
		return userList;
	}
	
	public User getDetailById(String id)
	{
		User user=userRepository.findOne(id);
		return user;
	}
	
	public User getDetailByName(String name)
	{
		User user=this.userRepository.findByUsername(name);
		return user;
	}
}
