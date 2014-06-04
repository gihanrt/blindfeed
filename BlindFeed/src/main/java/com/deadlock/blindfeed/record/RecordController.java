package com.deadlock.blindfeed.record;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecordController {
	
	@Autowired Services storeclips;
	
	private static final Logger logger = LoggerFactory.getLogger(RecordController.class);
	
	@RequestMapping(value = "/record", method = RequestMethod.GET)
	public String home1() {

		return "Recording/record";
	}
	
	
	@RequestMapping(value = "/record", method = RequestMethod.POST)
	public String returnpage(HttpServletRequest request) throws IOException{
		
		logger.info("starting method..............");
		String filename = request.getParameter("filename"); 
		System.out.print(filename);
		logger.info("post method executed......................");
		InputStream input = request.getInputStream();
		
		/*
		 * calling to service method
		 *  */
	    storeclips.SendToServer(input);
	    
        logger.info("finish.............");
        
		return "home";
	}

}
