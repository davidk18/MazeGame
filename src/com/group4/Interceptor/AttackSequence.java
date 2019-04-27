package com.group4.Interceptor;


public class AttackSequence {

	public void checkHealthBefore(Context mainCharacter, Context enemy, Dispatcher myDispatcher){

		Interceptor checkHealth = ConcreteInterecptor.getInstanceOfInterceptorAction();  // Concrete Interceptor creation Singleton
		myDispatcher.registerDispatcher(checkHealth);
		myDispatcher.preRequest(mainCharacter, enemy);//to update the context(enemy)
	}

	public void checkHealthAfter(Context mainCharacter, Context enemy, Dispatcher myDispatcher){

		Interceptor checkHealth = ConcreteInterecptor.getInstanceOfInterceptorAction();
		myDispatcher.registerDispatcher(checkHealth);
		myDispatcher.postRequest(mainCharacter, enemy); //to update the context (player) this means you attack first
	}
}



