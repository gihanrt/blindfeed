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

	@RequestMapping(value="/validation",method=RequestMethod.GET)
	public String DisplayData(HttpServletRequest request,Model model){

		List<Paragraph> list=paraDB.getpara();
		int length=list.size();
		
		if(length==0){
			
			return "TrustedUser/SQLexception";
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
	   
	    return "TrustedUser/validate";
	}
	}
	@RequestMapping(value="/validaccept",method=RequestMethod.GET)
	public String accept(HttpServletRequest request){
		
		HttpSession session = request.getSession(false);
		
		int para_id=(Integer) session.getAttribute("para_id");
		int book_id=(Integer) session.getAttribute("book_id");
		int user_id=(Integer) session.getAttribute("USERID");
		
		paraDB.accept_upadate1(para_id, book_id);
		paraDB.accept_upadate2(para_id, book_id,user_id);
		System.out.println("Sucessfully updated");
		return "TrustedUser/thankyou";
	}
	
	
	@RequestMapping(value="/validreject",method=RequestMethod.GET)
public String reject(HttpServletRequest request){
		
        HttpSession session = request.getSession(false);
		
		int para_id=(Integer) session.getAttribute("para_id");
		int book_id=(Integer) session.getAttribute("book_id");
		String path=(String) session.getAttribute("path");
		
		paraDB.audio_delete(para_id, book_id);
		paraDB.reject_upadate(para_id, book_id);
		
		//delete mp3
		//paraDB.mp3_delete(path);
		System.out.println(path);
		System.out.println("Sucessfully updated");
		return "TrustedUser/thankyou ";
	}
}
