package com.massiverun.constants;



import javax.xml.bind.annotation.XmlEnum;
@XmlEnum
public enum ErrorEnum {

	EXCEPTION(201,"Exception");
	
	private Integer errorCode;
	private String errorDesc;
	private ErrorEnum(Integer errorCode,String errDesc)
	{
		this.errorCode=errorCode;
		this.errorDesc=errorDesc;
	}
	
	public static ErrorEnum getError(Integer errorCode)
	{
		for(ErrorEnum err:values())
		{
			if(err.getErrorCode().equals(errorCode))
			{
				return err;
			}
		}
		return null;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
}
