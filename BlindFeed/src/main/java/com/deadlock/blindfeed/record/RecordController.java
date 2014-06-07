package com.deadlock.blindfeed.record;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public String home1(Model model) {
		
		/*
		 * book_id and paragrph_id should be saved in session to get when updating the record
		 * */
		List<Paragraph> list=paragraph.paragraphDisplay();
		model.addAttribute("paragraph", list.get(0));		
		return "Recording/record";
	}
	
	
	@RequestMapping(value = "/record", method = RequestMethod.POST)
	public String returnpage(HttpServletRequest request) throws IOException{
		
		logger.info("starting method..............");
		
		InputStream input = request.getInputStream();
		
		String mypath=request.getSession().getServletContext().getRealPath("resources/audio");
		
		System.out.println(mypath);
		
	    String path=storeclips.SendToServer(input,mypath);
	    
	    if((path.length()) != 0){
	    	//session ->{user id,paragrph id, book id}
	    	System.out.println(path);
	    	/*int userid=300;
	    	int paragraphid=401;
	    	int bookid=200;*/
	    	
	    	//paragraph.UpdateParagraphData(path,userid,paragraphid,bookid);
	    }
	    
        logger.info("finish.............");
        
		return "home";
	}

}
