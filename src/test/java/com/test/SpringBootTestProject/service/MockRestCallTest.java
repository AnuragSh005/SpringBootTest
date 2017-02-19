package com.test.SpringBootTestProject.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.RestTemplate;

import com.gargoylesoftware.htmlunit.javascript.host.fetch.Request;
import com.test.SpringBootTestProject.App;
import com.test.SpringBootTestProject.domain.User;
import com.test.SpringBootTestProject.restcontroller.RestControllerApi;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes=App.class)
@RestClientTest(RestControllerApi.class)
public class MockRestCallTest {
	
	@Autowired
	MockRestServiceServer server;
	
	@Autowired
	TestRestTemplate restTemplate;
	
	 /*@Before
	 public void setUp() {
		 server = MockRestServiceServer.createServer(restTemplate);
	    }*/
	 
	@Test
	public void getDetailsTest(){
		//this.server.expect(requestTo("/greet/details")).andRespond(withSuccess("hello", MediaType.TEXT_PLAIN));
		this.server.expect(MockRestRequestMatchers.requestTo("/getDetails")).andRespond(MockRestResponseCreators.withSuccess("hello", MediaType.TEXT_PLAIN));
		ResponseEntity<String> reponseEntity=this.restTemplate.getForEntity("/getDetails", String.class);
		String reponse1=reponseEntity.toString();
		assertThat(reponse1).contains("hello");
	}
}
