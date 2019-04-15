package com.group4.Interceptor;

public class Context {

	long time;
	String userName;
	
	Context(long time, String userName) {
		this.time = time;
		this.userName = userName;
	}
	
	
	long getTime() {
		return this.time;
	}
	
	String getUserName() {
		return this.userName;
	}
	
}
