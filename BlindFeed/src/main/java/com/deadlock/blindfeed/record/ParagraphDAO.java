package com.deadlock.blindfeed.record;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ParagraphDAO {

	 private JdbcTemplate jdbcTemplate;

	 
	 
	    @Autowired
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	
	    
	    public void paragraphDisplay(){
	    	//query=SELECT `Paragraph_ID`,`Para_text`,`Book_Book_ID` FROM `paragraph` WHERE `Audio_Flag`=0
	    }
	    
	    
	    public void UpdateParagraphData(){
	    	//need to find for one row Mapper there needs one paragraph at a time
	    }
	    
	    
}
