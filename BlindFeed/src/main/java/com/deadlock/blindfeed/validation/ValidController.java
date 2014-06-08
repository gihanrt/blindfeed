package com.deadlock.blindfeed.validation;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
	
	int para_id;
	int book_id;
	 String path;
	
	@RequestMapping(value="/validview",method=RequestMethod.GET)
	public String DisplayData(Model model){

		List<Paragraph> list=paraDB.getpara();
		
		int length=list.size();
		if(length==0){
			return "SQLexception";
		}
		else{
		model.addAttribute("PList", list.get(0));
		
		paraDB.accept_upadate1(para_id, book_id);
		
	    path=list.get(0).getLocation();
	    para_id=list.get(0).getParagraph_ID();
	    book_id=list.get(0).getBook_Book_ID();
	    model.addAttribute("loc_path", path);
	    System.out.println(path);
	   
	    return "validate";
	}
	}
	@RequestMapping(value="/validaccept",method=RequestMethod.GET)
	public String accept(){
		
		paraDB.accept_upadate1(para_id, book_id);
		//paraDB.accept_upadate2(para_id, book_id);
		System.out.println("Sucessfully updated");
		return "thankyou";
	}
	@RequestMapping(value="/validreject",method=RequestMethod.GET)
public String reject(Locale locale){
		
		
		paraDB.audio_delete(para_id, book_id);
		paraDB.reject_upadate(para_id, book_id);
		paraDB.mp3_delete(path);
		
		System.out.println("Sucessfully updated");
		return "thankyou ";
	}
}
