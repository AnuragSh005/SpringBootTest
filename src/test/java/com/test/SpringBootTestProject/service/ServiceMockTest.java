package com.test.SpringBootTestProject.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.SpringBootTestProject.App;
import com.test.SpringBootTestProject.Service.InjectedServiceClass;
import com.test.SpringBootTestProject.Service.ServiceProvider;
import com.test.SpringBootTestProject.domain.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes=App.class)
public class ServiceMockTest {
	
	@MockBean
	ServiceProvider serviceProvider;
	
	@Autowired
	InjectedServiceClass injectedServiceClass;
	
	@Test
	public void getDetailsByIdTest(){
		given(this.serviceProvider.getDetailById("1")).willReturn(new User("1","anshu"));
		User user=injectedServiceClass.getUserById("1");
		assertThat(user.getUsername()).isEqualTo("anshu");
	}
}
