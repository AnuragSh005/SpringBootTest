package com.test.SpringBootTestProject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.SpringBootTestProject.Service.ServiceProvider;
import com.test.SpringBootTestProject.domain.User;
import com.test.SpringBootTestProject.restcontroller.RestControllerApi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes=App.class)
public class AppTest 
{
	@Autowired
	TestRestTemplate restTemplate;
	
	
	@Test
	public void testGetDetailsCorrectly(){
		ResponseEntity<String> response1=this.restTemplate.getForEntity("/getDetails", String.class);
		String responseString=response1.toString();
		assertThat(responseString).contains("anurag");
	}
	
	@Test
	public void getDetailsByIdWhenIdIsPresent(){
		ResponseEntity<String> response1=this.restTemplate.getForEntity("/getDetailsById/1", String.class);
		String response=response1.toString();
		assertThat(response).contains("anurag");
	}
	
	/*@Test
	public void getDetailsByUsernameIsPresent(){
		given(this.serviceClass.getDetailByName("anurag")).willReturn(new User("4", "anurag"));
		User user=restControllerApi.getUserByName("anurag");
		assertThat(user.getId()).isEqualTo("4");
		
	}*/
	
}
