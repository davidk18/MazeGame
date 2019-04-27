package com.group4.Interceptor;

public interface Interceptor {

	void preRequest(Context mainCharacter, Context enemy);
	void postRequest(Context mainCharacter, Context enemy);
	
	
}
