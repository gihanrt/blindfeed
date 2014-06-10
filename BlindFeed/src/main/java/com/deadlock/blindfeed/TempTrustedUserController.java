package com.deadlock.blindfeed;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TempTrustedUserController {
	
	@RequestMapping(value="/userindex")
	public String TrustIndex(HttpServletRequest request,Model model){
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("USERNAME");
		model.addAttribute("user", user);
		return "TrustedUser/index";
	}
	
	@RequestMapping(value="/uservalidate",method=RequestMethod.GET)
	public String name1(HttpServletRequest request,Model model){
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("USERNAME");
		model.addAttribute("user", user);
		return "TrustedUser/validate";
	}
	
	@RequestMapping(value="/userabout",method=RequestMethod.GET)
	public String name2(HttpServletRequest request,Model model){
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("USERNAME");
		model.addAttribute("user", user);
		return "TrustedUser/about";
	}
	
	@RequestMapping(value="/usercontact",method=RequestMethod.GET)
	public String name3(HttpServletRequest request,Model model){
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("USERNAME");
		model.addAttribute("user", user);
		return "TrustedUser/contact";
	}
	
	@RequestMapping(value="/userhelp",method=RequestMethod.GET)
	public String name4(HttpServletRequest request,Model model){
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("USERNAME");
		model.addAttribute("user", user);
		return "TrustedUser/help";
	}

	@RequestMapping(value="/usercontribute",method=RequestMethod.GET)
	public String name5(HttpServletRequest request,Model model){
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("USERNAME");
		model.addAttribute("user", user);
		return "TrustedUser/contribute";
	}
}
