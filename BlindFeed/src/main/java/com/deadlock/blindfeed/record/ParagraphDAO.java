package com.deadlock.blindfeed.record;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class ParagraphDAO {

	 private JdbcTemplate jdbcTemplate;

	
	    @Autowired
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	
	    
	    public void UpdateParagraphData(String location,int userID,int paragrpahID,int bookID){
	    	
	   String sql="update `paragraph` set `AudioPara_Location`= ?, `Audio_Flag`=1, `User_UserID`= ? where `Paragraph_ID`= ? and `Book_Book_ID`= ?";
	    	
	   int data=this.jdbcTemplate.update(sql, location,userID,paragrpahID,bookID);
	   
	   		if(data !=0 ){
	   			System.out.println("data is updated.....................");
	   		}else{
	   			System.out.println("data is not updated.................");
	   		}
	    	
	    }
	    
	    
	    public List<Paragraph> paragraphDisplay(){
	    	String query="SELECT `Paragraph_ID`,`Para_text`,`Book_Book_ID` FROM `paragraph` WHERE `Audio_Flag`=0";	    	
	    	return this.jdbcTemplate.query(query,new ParagraphRowMapper());
	    }
	    
	    private static final class ParagraphRowMapper implements RowMapper<Paragraph>{
			@Override
			public Paragraph mapRow(ResultSet rs, int rowNum) throws SQLException {				
				Paragraph paragraph=new Paragraph();
				paragraph.setParagraphText(rs.getString("Para_text"));
				paragraph.setBookID(rs.getInt("Book_Book_ID"));
				paragraph.setParagraphID(rs.getInt("Paragraph_ID"));				
				return paragraph;
			}
			
		}
	    
	    
}
