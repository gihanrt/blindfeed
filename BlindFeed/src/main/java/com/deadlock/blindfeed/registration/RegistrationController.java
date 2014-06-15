package com.deadlock.blindfeed.registration;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

	@Autowired RegistrationDAO register;
	
	@RequestMapping(value="/regi",method=RequestMethod.GET)
	public String registration(Map<String,Object> model){
		Registration regdata=new Registration();
		model.put("form", regdata);
		return "registration/registration";
	}
	
	@RequestMapping(value="/regProcess",method=RequestMethod.POST)
	public String registrationMethod(@ModelAttribute("registration") Registration registration){
		
		String name=registration.getFName();
		String lname=registration.getLName();
		String email=registration.getEMail();
		String country=registration.getCountry();
		String language=registration.getLanguage();
		String pswd=registration.getPassword();
		int age=registration.getAge();
		
		System.out.println(name+" "+lname);
		System.out.println(email+ " "+country);
		System.out.println(language+" "+pswd);
		System.out.println(age);
		
		if(registration != null){
			
			List<Registration> list=register.checkList(email);
			
			if(list.size() == 0){
				register.register(registration);
				return "redirect:/welcome";
			}else{
				
			}
		}
		
		return "redirect:/regi";
		
		

	}
}
