package com.massiverun.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public abstract class BaseResponse implements Serializable {
	
	private ResponseCode respCode;

	public ResponseCode getResponseCode() {
		return respCode;
	}

	public void setResponseCode(ResponseCode responseCode) {
		this.respCode = responseCode;
	} 

}
