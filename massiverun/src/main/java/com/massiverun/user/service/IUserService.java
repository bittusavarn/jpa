package com.massiverun.user.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.massiverun.beans.request.user.LoginRequest;
/**
 * 
 * @author Nilamber Kumar
 *
 */
public interface IUserService {

	
	
	/**
	 * Check Creditial and Return User
	 * @param loginRequest
	 * @return
	 */
	
	@POST
    @Path("/login")
    @Produces({"application/xml","application/json"})
    @Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
    Response login(LoginRequest loginRequest);
	
}
