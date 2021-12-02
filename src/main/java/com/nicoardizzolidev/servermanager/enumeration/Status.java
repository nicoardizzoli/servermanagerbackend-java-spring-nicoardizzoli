package com.nicoardizzolidev.servermanager.enumeration;

public enum Status {
	SERVER_UP("SERVER_UP"),
	SERVER_DOWN("SERVER_DOWN");
	
	private final String status;
	
	private Status(String string) {
		this.status = string;
	}
	
	public String getStatus() {
		return this.status;
		
	}
}
