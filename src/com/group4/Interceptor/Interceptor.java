package com.group4.Interceptor;

import com.group4.Objects.CharacterPrototype;

public interface Interceptor {

	void preRequest(CharacterPrototype mainCharacter, CharacterPrototype enemy);
	void postRequest(CharacterPrototype mainCharacter, CharacterPrototype enemy);
	
	
}
