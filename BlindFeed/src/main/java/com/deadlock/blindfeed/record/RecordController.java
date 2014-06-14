package com.deadlock.blindfeed.record;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecordController {
	
	@Autowired Services storeclips;
	@Autowired ParagraphDAO paragraph;
	
	private static final Logger logger = LoggerFactory.getLogger(RecordController.class);
	
	@RequestMapping(value = "/record", method = RequestMethod.GET)
	public String home1(HttpServletRequest request,Model model) {
		
		/*
		 * book_id and paragrph_id should be saved in session to get when updating the record
		 * */
		
		//session
		HttpSession session=request.getSession(false);
		int type=(Integer) session.getAttribute("USERTYPE");
		
		String user=(String)session.getAttribute("USERNAME");
		
		List<Paragraph> list=paragraph.paragraphDisplay();
		
		System.out.println("******"+list.size()+"*****");
		
		
		if(list.size() == 0){
			
			if(type == 1){
				return "TrustedUser/sory";
			}else{
				return "RegisterdUser/sory";
			}
			
			
			
		}else{
			
			model.addAttribute("paragraph", list.get(0));
			
			int paragraph_id=list.get(0).getParagraphID();
			int book_id=list.get(0).getBookID();
			System.out.println(paragraph_id+" "+book_id);
			
			/*
			 * set to id's into session*/
			session.setAttribute("paragraphID", paragraph_id);
			session.setAttribute("bookID", book_id);
			
			if(type == 1){
				model.addAttribute("user", user);
				return "TrustedUser/record";
			}else{
				model.addAttribute("user", user);
				return "RegisterdUser/record";
			}
			
			
		}
		
		//Temper lock row
		//paragraph.updateTempory(paragraph_id, book_id);	
	}
	
	
	@RequestMapping(value = "/record", method = RequestMethod.POST)
	public String returnpage(HttpServletRequest request) throws IOException{
		
		logger.info("starting method..............");
		
		//get input stream
		InputStream input = request.getInputStream();
		//get path
		String mypath=request.getSession().getServletContext().getRealPath("resources/audio");
		System.out.println(mypath);
		//send to services
	    String path=storeclips.SendToServer(input,mypath);
	    
	    //get session
	    HttpSession ses=request.getSession(false);
	    int paragrpahID=(Integer) ses.getAttribute("paragraphID");
	    int bookID=(Integer) ses.getAttribute("bookID");
	    int type=(Integer) ses.getAttribute("USERTYPE");
	    System.out.println(paragrpahID+" "+bookID);
	    
	    //get userID
	    int userID=(Integer) ses.getAttribute("USERID");
	    
	    if((path.length()) != 0){
	    	System.out.println(path);
	    	String fullpath="resources/audio/"+path;
	         paragraph.UpdateParagraphData(fullpath,userID,paragrpahID,bookID);
	    }
	    
        logger.info("finish.............");
        
        if(type == 1){
        	
        	System.out.println("trusted user index page executed");
        	return "redirect:/userindex";
        }else{
        	System.out.println("normal user index page executed");
        	return "RegisterdUser/index";
        }
		
	}

}
