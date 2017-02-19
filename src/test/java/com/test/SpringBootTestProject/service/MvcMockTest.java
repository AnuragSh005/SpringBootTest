package com.test.SpringBootTestProject.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.test.SpringBootTestProject.Service.ServiceProvider;
import com.test.SpringBootTestProject.controller.MvcController;
import com.test.SpringBootTestProject.domain.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(MvcController.class)
public class MvcMockTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean 
	ServiceProvider serviceProvider;
	
	@Test
	public void getDetailsMethodTest() throws Exception{
		User user1=new User("1", "ansh");
		List<User> l=new ArrayList<>();
		l.add(user1);
		given(this.serviceProvider.getDetails()).willReturn(l);
		
		/*this.mvc.perform(post("/getDetailsMvc").accept(MediaType.TEXT_PLAIN))
			.andExpect(status().isOk())
			.andExpect(view().name("foundDetails"));*/
		
		/*this.mvc.perform(post("/getDetailsMvc").accept(MediaType.TEXT_PLAIN))
		.andExpect(status().isOk())
		.andExpect(model().attribute("user", user1));*/
		
		this.mvc.perform(post("/getDetailsMvc").accept(MediaType.TEXT_PLAIN))
		.andExpect(status().isOk())
		.andExpect(view().name("foundDetails"))
		.andExpect(model().attribute("user",user1));
	}
}
