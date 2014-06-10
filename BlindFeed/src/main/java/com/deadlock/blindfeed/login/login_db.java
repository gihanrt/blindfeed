package com.deadlock.blindfeed.login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//import com.sahan.show_para1.Paragraph;
//import com.sahan.show_para1.para_DB.ParaRowMapper;

public class login_db implements login_DAO {
	 private JdbcTemplate jdbcTemplate;
	 
	 @Autowired
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	 
	@Override
	public String checker(String EMail) {
		//String sql="SELECT `Password` FROM `User` WHERE `EMail`="+EMail+"  ";
		 return null;
	}
	 private static final class ParaRowMapper implements RowMapper<login>{
			@Override
			public login mapRow(ResultSet rs, int rowNum) throws SQLException {
				login login_check=new login();
				login_check.setPassword(rs.getString("Password"));
				login_check.setUser_ID(rs.getInt("User_ID"));
				login_check.setFName(rs.getString("FName"));
				login_check.setTrustedUser_Flag(rs.getInt("TrustedUser_Flag"));
				
				return login_check;
			}
			
		}
	@Override
	public List<login> getpassword(String EMail) {
		String sql="SELECT `Password`,`FName`,`User_ID`,`TrustedUser_Flag` FROM `user` WHERE `EMail`= ? ";
		  return this.jdbcTemplate.query(sql,new Object[]{EMail},new ParaRowMapper());
	}

	
}
