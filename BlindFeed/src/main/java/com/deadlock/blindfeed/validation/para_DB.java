package com.deadlock.blindfeed.validation;


import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jca.cci.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class para_DB implements para_DAO{
	
	
	 private JdbcTemplate jdbcTemplate;

	 /*
	  * setter the datasource that is defined in servlet configuration file 
	  * */
	 
	    @Autowired
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	    
	    
	    private static final class ParaRowMapper implements RowMapper<Paragraph>{
			@Override
			public Paragraph mapRow(ResultSet rs, int rowNum) throws SQLException {
				Paragraph paragraph=new Paragraph();
				paragraph.setPara_text(rs.getString("Para_text"));
				paragraph.setLocation(rs.getString("AudioPara_Location"));
				paragraph.setParagraph_ID(rs.getInt("paragraph_ID"));
				paragraph.setBook_Book_ID(rs.getInt("Book_Book_ID"));
				return paragraph;
			}
			
		}
		

	@Override
	public List<Paragraph> getpara() {
		try
		{
		String sql="SELECT `Para_text`,`AudioPara_Location`,`Paragraph_ID`,`Book_Book_ID` FROM `paragraph` WHERE `Audio_Flag`=1 AND `Authenticate_Flag`=0   ";
		return this.jdbcTemplate.query(sql, new ParaRowMapper());
		}
		catch (InvalidResultSetAccessException e) 
		{
		    throw new RuntimeException(e);
		} 
		catch (DataAccessException e)
		{
		    throw new RuntimeException(e);
		}
	
	}
	
	
	
	@Override
	public void accept_upadate1(int para_id, int book_id) {
		String sql="UPDATE `paragraph` SET `Authenticate_Flag`=1 WHERE `paragraph_ID`="+para_id+" AND `Book_Book_ID`= "+book_id+" ";
		jdbcTemplate.update(sql);
		System.out.println("Done");
		
	}
	
	
	
	
	@Override
	public void accept_upadate2(int para_id,int book_id){
		
		
		//String sql="UPDATE `paragraph` SET `User_authenticate_User_ID`=**** WHERE `paragraph_ID`="+para_id+" AND `Book_Book_ID`= "+book_id+" ";
		//jdbcTemplate.update(sql);
		//System.out.println("Done");
		
	}
	
	
	@Override
	public void reject_upadate(int para_id,int book_id){
		String sql="UPDATE `paragraph` SET `Audio_Flag`=0 WHERE `paragraph_ID`="+para_id+" AND `Book_Book_ID`= "+book_id+" ";
		
		jdbcTemplate.update(sql);
		System.out.println("Done");
		
	}
	
	
	@Override
	public void audio_delete(int para_id,int book_id){
		String sql="UPDATE `paragraph` SET `AudioPara_Location`=' ' WHERE `paragraph_ID`="+para_id+" AND `Book_Book_ID`= "+book_id+" ";
		jdbcTemplate.update(sql);
		System.out.println("Done");
		
		
	}


	@Override
	public void mp3_delete(String path) {
		try{
			String Path=path;
			 
    		File file = new File("C:/Users/sahan/Desktop/New folder (2)/show_para/src/main/webapp/"+Path);
 
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
 
    	}catch(Exception e){
 
    		e.printStackTrace();
 
    	}
		
	}
	
}
