package com.group4.Interceptor;

import com.group4.Objects.CharacterPrototype;

public class AttackSequence {
	
	public void checkHealthBefore(CharacterPrototype mainCharacter, Dispatcher myDispatcher) {
		
		Interceptor checkHealth = ConcreteInterecptor.getInstanceOfInterceptorAction();  // Concrete Interceptor creation Singleton
		
		myDispatcher.registerDispatcher(checkHealth);
		myDispatcher.preRequest(mainCharacter);
	}
	
	
	public void checkHealthAfter(CharacterPrototype mainCharacter , Dispatcher myDispatcher) {
		
		Interceptor checkHealth = ConcreteInterecptor.getInstanceOfInterceptorAction();
		
		myDispatcher.registerDispatcher(checkHealth);
		myDispatcher.postRequest(mainCharacter);
	}
}



