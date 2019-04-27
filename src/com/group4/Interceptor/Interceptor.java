package com.group4.Interceptor;

import com.group4.Prototype.CharacterPrototype;

public interface Interceptor {

	void preRequest(Context mainCharacter, Context enemy);
	void postRequest(Context mainCharacter, Context enemy);
	
	
}
