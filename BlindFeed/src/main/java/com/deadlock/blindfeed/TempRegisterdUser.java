package com.deadlock.blindfeed;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TempRegisterdUser {

	@RequestMapping(value="/Nuserindex")
	public String TrustIndex(HttpServletRequest request,Model model){
		HttpSession session=request.getSession(false);
		String username=(String)session.getAttribute("USERNAME");
		model.addAttribute("user", username);
		System.out.println(username);
		return "RegisterdUser/index";
	}
	
	@RequestMapping(value="/Nuserabout",method=RequestMethod.GET)
	public String name2(HttpServletRequest request,Model model){
		HttpSession session=request.getSession(false);
		String username=(String)session.getAttribute("USERNAME");
		model.addAttribute("user", username);
		System.out.println(username);
		return "RegisterdUser/about";
	}
	
	@RequestMapping(value="/Nusercontact",method=RequestMethod.GET)
	public String name3(HttpServletRequest request,Model model){
		HttpSession session=request.getSession(false);
		String username=(String)session.getAttribute("USERNAME");
		model.addAttribute("user", username);
		System.out.println(username);
		return "RegisterdUser/contact";
	}
	
	@RequestMapping(value="/Nuserhelp",method=RequestMethod.GET)
	public String name4(HttpServletRequest request,Model model){
		
		HttpSession session=request.getSession(false);
		
		if(session != null){

			String username=(String)session.getAttribute("USERNAME");
			
			String id=(String)session.getAttribute("ID");
			String ids=(String)session.getId();
			
			if(id.equals(ids)){
				model.addAttribute("user", username);
				System.out.println(username);
				return "RegisterdUser/help";
			}else{
				return null;
			}
		}else{
			return null;
		}
		
		
	}

	/*@RequestMapping(value="/Nusercontribute",method=RequestMethod.GET)
	public String name5(){
		return "Recording/record";
	}*/

}
