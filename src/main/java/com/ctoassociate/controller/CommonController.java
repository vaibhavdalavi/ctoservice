package com.ctoassociate.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctoassociate.models.LoginRequest;
import com.ctoassociate.models.LoginResponse;
import com.ctoassociate.models.ServiceResponse;
import com.ctoassociate.models.User;
import com.ctoassociate.repository.UserRepository;
import com.ctoassociate.service.AuthenticationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "ctoassociate")
@CrossOrigin
@RestController
@RequestMapping("/ctoassociate")
public class CommonController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CommonController.class);
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public AuthenticationService authenticationService;
	
	@ApiOperation(nickname = "createUser", value = "To create a new user.")
	@RequestMapping(value = "/createUser", method = RequestMethod.POST, consumes = "application/json",  produces = "application/json")
	public ResponseEntity<ServiceResponse> insertUser(@RequestBody User user) {
		logger.info("inserting user ...");
		return ResponseEntity.ok(userRepository.insert(user));
	}
	
	@ApiOperation(nickname = "login", value = "Used to check user authentication to the service.")
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json",  produces = "application/json")
	public @ResponseBody ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		LoginResponse response = new LoginResponse();
		try {
			User user = authenticationService.authenticate(loginRequest);
			String uuid = UUID.randomUUID().toString();
			/*Util.addCookie(httpServletResponse, Constants.JSESSIONID, uuid, -1);
			Util.addCookie(httpServletResponse, Constants.USER_NAME, user.getUsername(), -1);*/
			
			//auditLoginDetail(user.getName(), uuid, httpServletRequest, httpServletResponse);
			
			response.setUser(user);
			
			return ResponseEntity.ok(response);
		} catch (Throwable e) {
			/*Util.deleteCookie(httpServletResponse, Constants.JSESSIONID);
			ResponseEntity<ServiceResponse> badRequest = badRequest(e);
			response.update(badRequest.getBody());
			return ResponseEntity.status(badRequest.getStatusCodeValue()).body(response);*/
			return ResponseEntity.ok(new LoginResponse());
		}
		
	}

}
