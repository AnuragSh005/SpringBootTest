package com.test.SpringBootTestProject.domainTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.SpringBootTestProject.App;
import com.test.SpringBootTestProject.domain.User;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes=App.class)
@DataJpaTest
public class userTestClass {
	
	@Rule
	public ExpectedException thrown=ExpectedException.none();
	
	@Test
	public void createUserWithNullValueShouldThrowException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("name cannot be null");
		new User("1", null);
	}
	@Test
	public void createUserWithZeroLengthShouldThrowException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("length cannt be 0 ");
		new User("1", "");
	}
	@Test
	public void createUserWithAllValidFieldsShouldNotThrowException(){
		new User("1", "anurag");
	}
	
}
