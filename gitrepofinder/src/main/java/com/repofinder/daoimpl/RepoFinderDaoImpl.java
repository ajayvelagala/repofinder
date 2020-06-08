package com.repofinder.daoimpl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.repofinder.dao.RepoFinderDao;
import com.repofinder.model.UserSearch;

@Repository
public class RepoFinderDaoImpl implements RepoFinderDao {  

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insertUserInfo(String username,String searchResult) {
		 try {
		 String Query =" INSERT INTO USER_SEARCH_BY_RESULT(NAME, created_date, SEARCH_RESULT) VALUES(?,now(),?)" ;
		 
		 		Object args[] = new Object[] {username,searchResult};
		 		int recordsInserted = jdbcTemplate.update(Query, args);
		 		System.out.println(recordsInserted);
			
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		
	}

	
	public List<UserSearch> findAllByString() {
        String sql = "SELECT * FROM USER_SEARCH_BY_RESULT";
        List<UserSearch> customers = jdbcTemplate.query(
                sql,
                new UserSearchRowMapper());
        return customers;

    }
	
	 class UserSearchRowMapper implements RowMapper<UserSearch> {
	    @Override
	    public UserSearch mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	UserSearch userSearch = new UserSearch(rs.getString("id"), rs.getString("name"),
	    			rs.getString("search_result"),rs.getString("created_date"));
	    	
	        return userSearch;

	    }
	}
	
}

