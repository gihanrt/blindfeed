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
	String normalpath;
	
	public String SendToServer(InputStream stream, String path) throws IOException{
		
		byte[] buffer = new byte[8192];
	    int bytesRead;
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    while ((bytesRead = stream.read(buffer)) != -1)
	    {
	        output.write(buffer, 0, bytesRead);
	    }
	    
	    logger.info("start createing file.................");
		
		
		File folder=new File(path);
		   
		    
	    if(folder.exists()){
	  
	    	System.out.println("audio resource folder exists ");
			File[] listOfFiles = folder.listFiles();
			int count=listOfFiles.length+1;
			//String realpath=path+"/"+"AudioClip"+count+".mp3";
			
			normalpath="AudioClip"+count+".mp3";
			
			completepath=path+"/"+normalpath;
			
			File someFile = new File(completepath);
			
			
		    FileOutputStream fos = new FileOutputStream(someFile);
		    System.out.println("====="+completepath+"=====");
		    System.out.println("====="+someFile.getAbsolutePath()+"======"); 
	
        fos.write(output.toByteArray());
        fos.flush();
        fos.close();
        
	    }else if(!(folder.exists())){
	    	
	    	System.out.println("audio resource folder not exists  but create");
			File[] listOfFiles = folder.listFiles();
			int count=listOfFiles.length+1;
			//String realpath=path+"/"+"AudioClip"+count+".mp3";
			
			normalpath="AudioClip"+count+".mp3";
			
			completepath=path+"/"+normalpath;
			
			File someFile = new File(completepath);
			
			
		    FileOutputStream fos = new FileOutputStream(someFile);
		    System.out.println("====="+completepath+"=====");
		    System.out.println("====="+someFile.getAbsolutePath()+"======"); 
	
	    }
		return normalpath;
	}
}
