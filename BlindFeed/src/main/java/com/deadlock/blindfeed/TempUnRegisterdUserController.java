package com.deadlock.blindfeed;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TempUnRegisterdUserController {

	/*@RequestMapping(value="/index",method=RequestMethod.GET)
	public String name(){
		return "unreguser/index";
	}
	*/
	@RequestMapping(value="/reg",method=RequestMethod.GET)
	public String name1(){
		return "unreguser/reguser";
	}
	
	@RequestMapping(value="/about",method=RequestMethod.GET)
	public String name2(){
		return "unreguser/about";
	}
	
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public String name3(){
		return "unreguser/contact";
	}
	
	@RequestMapping(value="/help",method=RequestMethod.GET)
	public String name4(){
		return "unreguser/help";
	}
}
