package com.test.SpringBootTestProject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name="usertable")
public class User {
	@Id
	private String id;
	@Column(unique=true)
	private String username;
	
	protected User() {
		
	}
	public User(String id,String name) {
		Assert.notNull(name,"name cannot be null");
		Assert.hasLength(name,"length cannt be 0 ");
		this.id=id;
		this.username=name;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		User user2=(User) obj;
		if(this.id.equals(user2.getId()) && this.username.equals(user2.getUsername()))
			return true;
		else 
			return false;
			
		
	}
	
}
