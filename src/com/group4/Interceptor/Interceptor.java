package com.group4.Interceptor;

public interface Interceptor {

	void preRequest(Context context);
	void postRequest(Context context);
	
	
}
