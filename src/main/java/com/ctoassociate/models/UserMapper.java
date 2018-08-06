package com.ctoassociate.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet resultSet, int arg1) throws SQLException {
		User user = new User();
		user.setId(resultSet.getLong("id"));
		user.setName(resultSet.getString("name"));
		user.setEmail(resultSet.getString("email"));
		user.setPassword(resultSet.getString("password"));
		return user;
	}

}	
