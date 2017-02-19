package com.test.SpringBootTestProject.domain;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Serializable>{
	
	 User findByUsername(String username);
}
