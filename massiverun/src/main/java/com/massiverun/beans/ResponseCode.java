package com.massiverun.beans;

import java.io.Serializable;
import java.util.List;



public class ResponseCode implements Serializable{

	private Boolean error;
	
	private List<Error> errors;
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public List<Error> getErrors() {
		return errors;
	}
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
	
	
}
