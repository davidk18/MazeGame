package com.group4.Interceptor;

import com.group4.Objects.CharacterPrototype;

public interface Interceptor {

	void preRequest(CharacterPrototype mainCharacter);
	void postRequest(CharacterPrototype mainCharacter);
	
	
}
