package com.group4.Interceptor;

import com.group4.Objects.CharacterProduct;

public class AttackSequence {
	
	public void checkHealthBefore(CharacterProduct mainCharacter, Dispatcher myDispatcher) {
		
		Interceptor checkHealth = ConcreteInterecptor.getInstanceOfInterceptorAction();  // Concrete Interceptor creation Singleton
		
		myDispatcher.registerDispatcher(checkHealth);
		myDispatcher.preRequest(mainCharacter);
	}
	
	
	public void checkHealthAfter(CharacterProduct mainCharacter , Dispatcher myDispatcher) {
		
		Interceptor checkHealth = ConcreteInterecptor.getInstanceOfInterceptorAction();
		
		myDispatcher.registerDispatcher(checkHealth);
		myDispatcher.postRequest(mainCharacter);
	}
}



