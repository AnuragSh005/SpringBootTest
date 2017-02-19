package com.test.SpringBootTestProject.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.test.SpringBootTestProject.Service.ServiceProvider;
import com.test.SpringBootTestProject.controller.MvcController;
import com.test.SpringBootTestProject.domain.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

import java.io.IOException;
import java.net.MalformedURLException;

@RunWith(SpringRunner.class)
@WebMvcTest(MvcController.class)
public class HtmlUnitTests {
	
	@Autowired
	WebClient webClient;
	
	@MockBean
	ServiceProvider serviceProvider;
	
	@Test
	public void testHtmlPageContent() {
		given(this.serviceProvider.getDetailByName("ansh")).willReturn(new User("5", "ansh"));
		HtmlPage page1=null;
		try {
			page1 = this.webClient.getPage("/ansh/vehicle.html");
		} catch (FailingHttpStatusCodeException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("page is "+page1.getBody().getTextContent());
		assertThat(page1.getBody().getTextContent()).isEqualTo("5 ansh");
	}
}
