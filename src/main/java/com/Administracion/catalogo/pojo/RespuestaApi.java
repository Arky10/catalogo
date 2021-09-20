package com.Administracion.catalogo.pojo;

public class RespuestaApi {
    
	public int code;
	public String message;
	
	
	public RespuestaApi(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
