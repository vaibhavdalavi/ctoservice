package com.ctoassociate.service;

import com.ctoassociate.models.LoginRequest;
import com.ctoassociate.models.User;

public interface AuthenticationService {

	User authenticate(LoginRequest loginRequest) throws Exception;

}
