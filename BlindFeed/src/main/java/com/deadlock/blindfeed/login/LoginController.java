package com.deadlock.blindfeed.login;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	@Autowired login_db jdbc;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String registerdata(Map<String,Object> model){
	
		login newlogin=new login();
		model.put("login_user", newlogin);
		
		return "unreguser/index";
	}
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String registerdata1(Map<String,Object> model){
	
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/login1",method=RequestMethod.POST)
	public String rgistrationdata(HttpServletRequest request,@ModelAttribute("login_user") login newlogin,Model model){
		
		logger.info("Starting......");
	
		//user entered
		String EMail=newlogin.getEMail();
		String type_password=newlogin.getPassword();
		
		//check email in database
		List<login> list=jdbc.getpassword(EMail);
		
		//get available login
		String password=list.get(0).getPassword();
		int user_id=list.get(0).getUser_ID();
		String username=list.get(0).getFName();
		int user_type=list.get(0).getTrustedUser_Flag();
		
		//session started
		  HttpSession session=request.getSession();
		  session.setAttribute("USERNAME",username);
		  session.setAttribute("USERID",user_id);
		  session.setAttribute("USERTYPE", user_type);
		  String SessionID=(String)session.getId();
		  session.setAttribute("ID", SessionID);
	
		
		System.out.println("type password= "+type_password);
		System.out.println("type email= "+EMail);
		System.out.println("DB password= "+password);
		System.out.println("DB Email= "+EMail);
		
		//authentication
		if (password.equals(type_password)){
			if(user_type==1){
				
				System.out.println("You have loged in as "+ username);
				model.addAttribute("user",username);
				return "TrustedUser/index";
			}
			else{
				System.out.println("You have loged in as "+ username);
				model.addAttribute("user",username);
				return"RegisterdUser/index";
			}
		}
		else 
			System.out.println("Wrong E-Mail or Password");
			return "unreguser/error";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String test4(HttpServletRequest request){
		
		request.getSession(false).invalidate();
		
		return "redirect:/";
	}
}
