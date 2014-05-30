package com.deadlock.blindfeed.record;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecordController {
	
	private static final Logger logger = LoggerFactory.getLogger(RecordController.class);
	
	@RequestMapping(value = "/record", method = RequestMethod.GET)
	public String home1() {

	/*	File file=new File("C:/Users/Hunter/Desktop/audio\\dir");
		
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}*/
		
		return "Recording/record";
	}
	
	
	@RequestMapping(value = "/record", method = RequestMethod.POST)
	public String returnpage(HttpServletRequest request) throws IOException{
		
		logger.info("starting method..............");
		String filename = request.getParameter("filename"); 
		System.out.print(filename);
		logger.info("post method executed......................");
		InputStream input = request.getInputStream();
		byte[] buffer = new byte[8192];
	    int bytesRead;
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    while ((bytesRead = input.read(buffer)) != -1)
	    {
	        output.write(buffer, 0, bytesRead);
	    }
	    
	    logger.info("start createing file.................");
		File someFile = new File("C:/Users/Hunter/Desktop/audio/sample.mp3");
        FileOutputStream fos = new FileOutputStream(someFile);
        //AudioSystem.write(oAIS, AudioFileFormat.Type.WAVE, someFile);
        fos.write(output.toByteArray());
        fos.flush();
        fos.close();
        logger.info("finish.............");
		return "home";
	}

}
