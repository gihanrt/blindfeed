package com.deadlock.template.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.deadlock.template.model.Person;

public class PersonDAOImpl implements PersonDAO {

	 private JdbcTemplate jdbcTemplate;

	 /*
	  * setter the datasource that is defined in servlet configuration file 
	  * */
	 
	    @Autowired
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	
	    
	 /*
	  * inserting person object into database
	  * jdbc template update method can be used for inser,update,delete
	  * executes the query
	  * */   
	@Override
	public void insert(Person person) {
	
		//String sql="UPDATE `paragraph` SET `Authenticat _Flag`=1 WHERE `paragraph_ID`="+para_id+" AND `Book_Book_ID`= "+book_id+" ";
		
		String sql="INSERT INTO person"+"(fname,lname,age) VALUES (?,?,?)";
		int data=jdbcTemplate.update(sql, new Object[]{person.getFname(),person.getLname(),person.getAge()});
		
		if(data !=0	){
			System.out.println("data inserted");
			
		}else{
			System.out.println("there is error");
		}
		
	}

	/*
	 * return the list of persons who are available in database
	 * it uses rowmapper inner class to get row data  
	 * and set it to person objects
	 * */
	@Override
	public List<Person> getPersonList() {
		String sql="SELECT * from person";
		return this.jdbcTemplate.query(sql, new PersonRowMapper());
	}
	
	private static final class PersonRowMapper implements RowMapper<Person>{
		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person=new Person();
			person.setFname(rs.getString("fname"));
			person.setLname(rs.getString("lname"));
			person.setAge(rs.getInt("age"));
			return person;
		}
		
	}
	
	

}
