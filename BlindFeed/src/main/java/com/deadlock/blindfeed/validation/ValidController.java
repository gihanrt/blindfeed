package com.deadlock.blindfeed.validation;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deadlock.blindfeed.validation.para_DB;
/**
 * Handles requests for the application home page.
 */
@Controller
public class ValidController {
@Autowired para_DB paraDB;
	
	private static final Logger logger = LoggerFactory.getLogger(ValidController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/validation", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
     
	
	@RequestMapping(value="/validview",method=RequestMethod.GET)
	public String DisplayData(HttpServletRequest request,Model model){

		List<Paragraph> list=paraDB.getpara();
		int length=list.size();
		if(length==0){
			return "SQLexception";
		}
		else{
		HttpSession session = request.getSession();
		
		    int para_id=list.get(0).getParagraph_ID();
			int book_id=list.get(0).getBook_Book_ID();
			String path=list.get(0).getLocation();
		
		 session.setAttribute("para_id",para_id);
		 session.setAttribute("book_id",book_id);
		 session.setAttribute("path",path);
		
		
		
		
		model.addAttribute("PList", list.get(0));
		
		paraDB.accept_upadate1(para_id, book_id);
		
	    
	    model.addAttribute("loc_path", path);
	    System.out.println(path);
	   
	    return "validate";
	}
	}
	@RequestMapping(value="/validaccept",method=RequestMethod.GET)
	public String accept(HttpServletRequest request){
		
		HttpSession session = request.getSession(false);
		
		int para_id=(Integer) session.getAttribute("para_id");
		int book_id=(Integer) session.getAttribute("book_id");
		//int user_id=Integer) session.getAttribute("user_id");
		paraDB.accept_upadate1(para_id, book_id);
		//paraDB.accept_upadate2(para_id, book_id,user_id);
		System.out.println("Sucessfully updated");
		return "thankyou";
	}
	@RequestMapping(value="/validreject",method=RequestMethod.GET)
public String reject(HttpServletRequest request){
		
		
		
            HttpSession session = request.getSession(false);
		
		int para_id=(Integer) session.getAttribute("para_id");
		int book_id=(Integer) session.getAttribute("book_id");
		String path=(String) session.getAttribute("path");
		
		paraDB.audio_delete(para_id, book_id);
		paraDB.reject_upadate(para_id, book_id);
		paraDB.mp3_delete(path);
		
		System.out.println("Sucessfully updated");
		return "thankyou ";
	}
}
