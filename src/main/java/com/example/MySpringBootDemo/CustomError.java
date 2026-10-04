package com.example.MySpringBootDemo;

public class CustomError extends RuntimeException {

	private int status;
	public CustomError(int status,String msg) {
		super(msg);
		this.status=status;
		
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
