package com.test.SpringBootTestProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.test.SpringBootTestProject.Service.ServiceProvider;
import com.test.SpringBootTestProject.domain.User;


@Controller
//@RestController // for webclient 
public class MvcController {
	
	@Autowired
	ServiceProvider serviceProvider;
	
	@RequestMapping(value="/getDetailsMvc", method=RequestMethod.POST, produces=MediaType.TEXT_PLAIN_VALUE)
	public String getDetailsMvc(Model model){
		List<User> user=this.serviceProvider.getDetails();
		//ModelAndView model1=new ModelAndView("foundDetails");
		//model1.addObject("user",user);
		User u1=new User("1", "ansh");
		model.addAttribute("user",u1);
		return "foundDetails";
	}
	
	@RequestMapping(path = "/{username}/vehicle.html", produces = MediaType.TEXT_HTML_VALUE)
	public String getDetailsHTMLPage(@PathVariable String username) {
		User user=this.serviceProvider.getDetailByName(username);
		String userDetails = user.getId() + " " + user.getUsername();
		return "<html><body><h1>" + userDetails + "</h1></body></html>";
	}
	
	/*@RequestMapping(value="/getDetailsMvc", method=RequestMethod.GET, produces=MediaType.TEXT_PLAIN_VALUE)
	public List<User> getDetailsMvc(){
		List<User> user=this.serviceProvider.getDetails();
		return user;
	}*/
}
