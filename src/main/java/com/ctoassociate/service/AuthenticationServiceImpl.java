package com.ctoassociate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.ctoassociate.models.LoginRequest;
import com.ctoassociate.models.User;
import com.ctoassociate.repository.UserRepository;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	public UserRepository userRepository;
	
	@Transactional
	@Override
	public User authenticate(LoginRequest loginRequest) throws Exception {

		if (loginRequest == null || StringUtils.isEmpty(loginRequest.getName()) || StringUtils.isEmpty(loginRequest.getPassword())) {
			throw new Exception("Username and Password are required.");
		}

		User user = userRepository.findUserByUserName(loginRequest.getName());

		if (null != user) {
			return user;
		} else {
			throw new Exception("User '" + loginRequest.getName() + "' not found");
		}
		
		
	}

}
