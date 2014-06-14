package com.deadlock.blindfeed.registration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class RegistrationDAO {

	private JdbcTemplate jdbcTemplate;

	
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    

	public void register(Registration registration) {
		String sql="INSERT INTO user"+"(FName,LName,Age,EMail,Country,Languages,Password) VALUES (?,?,?,?,?,?,?)";
		int data=jdbcTemplate.update(sql, new Object[]{registration.getFName(),registration.getLName(),registration.getAge(),registration.getEMail(),registration.getCountry(),registration.getLanguage(),registration.getPassword()});
		
		if(data !=0	){
			System.out.println("data inserted");
			
		}else{
			System.out.println("there is error");
		}
		
	}
	
    public List<Registration> checkList(String email){
    	String sql="SELECT `FName` FROM `user` WHERE `EMail`= ? ";
		  return this.jdbcTemplate.query(sql,new Object[]{email},new ParaRowMapper());
    }
    
    
    private static final class ParaRowMapper implements RowMapper<Registration>{
		@Override
		public Registration mapRow(ResultSet rs, int rowNum) throws SQLException {
			Registration reg=new Registration();
			reg.setFName(rs.getString("FName"));
			return reg;
		}
		
	}
    
    
}
