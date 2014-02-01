package com.massiverun.user.service.impl;

import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;

import com.massiverun.beans.Error;
import com.massiverun.beans.ResponseCode;
import com.massiverun.beans.request.user.LoginRequest;
import com.massiverun.beans.response.user.LoginResponse;
import com.massiverun.constants.ErrorEnum;
import com.massiverun.constants.PreCacheCriteria;
import com.massiverun.pojo.Test;
import com.massiverun.user.service.IUserService;


public class UserService implements IUserService{

	
	
	public Response login(LoginRequest loginRequest) {
		LoginResponse loginResponse=new LoginResponse();
		ResponseCode responseCode=new ResponseCode();
		responseCode.setError(Boolean.TRUE);
		List<Error> errors=new ArrayList<Error>();
		Error error=new Error();
		error.setErrorCode(ErrorEnum.EXCEPTION.getErrorCode());
		error.setErrorDesc(ErrorEnum.EXCEPTION.getErrorDesc());
		errors.add(error);
		responseCode.setErrors(errors);
        loginResponse.setResponseCode(responseCode);
        PreCacheCriteria preCacheCriteria =new PreCacheCriteria();
        try {
			preCacheCriteria.afterPropertiesSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok(loginResponse).build();
	}

	

}
