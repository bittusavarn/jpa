package com.massiverun.beans.response.user;

import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.massiverun.beans.BaseResponse;

/**
 * 
 * @author Nilamber Kumar
 *
 */
@XmlRootElement(name="LoginResp")
@XmlAccessorOrder
public class LoginResponse extends BaseResponse{

	private Boolean loggedIn;
	
	private String  dispName;
	
	private String  userId;

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getDispName() {
		return dispName;
	}

	public void setDispName(String dispName) {
		this.dispName = dispName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
