package com.group4.Interceptor;

import com.group4.Objects.CharacterProduct;

public interface Interceptor {

	void preRequest(CharacterProduct mainCharacter);
	void postRequest(CharacterProduct mainCharacter);
	
	
}
