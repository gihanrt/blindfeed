package com.deadlock.blindfeed.record;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Services {
	
	private static final Logger logger = LoggerFactory.getLogger(Services.class);

	String completepath;
	
	public String SendToServer(InputStream stream) throws IOException{
		
		byte[] buffer = new byte[8192];
	    int bytesRead;
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    while ((bytesRead = stream.read(buffer)) != -1)
	    {
	        output.write(buffer, 0, bytesRead);
	    }
	    
	    logger.info("start createing file.................");
		

	    String path="C:/Users/Hunter/Desktop/audio/";
		
		File folder=new File(path);
		    File[] listOfFiles = folder.listFiles();
		    
	    if(folder.exists()){
	    	
	    	
			    int count=listOfFiles.length+1;
			    completepath=path+"AudioClip"+count+".mp3";
			    File someFile = new File(path+"AudioClip"+count+".mp3");
			    FileOutputStream fos = new FileOutputStream(someFile);
			
	        //AudioSystem.write(oAIS, AudioFileFormat.Type.WAVE, someFile);
	        fos.write(output.toByteArray());
	        fos.flush();
	        fos.close();
	    	
	    	
	    }else{
	    	logger.info("there is no such folder");
	    }
		return completepath;
	}
}
