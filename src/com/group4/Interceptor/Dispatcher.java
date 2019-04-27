package com.group4.Interceptor;

import java.util.ArrayList;
import com.group4.Prototype.CharacterPrototype;

public class Dispatcher implements Interceptor{

	ArrayList<Interceptor> Interceptors = new ArrayList<Interceptor>();
	
	private static Dispatcher thisDispatcher;
	
	private Dispatcher() {
		
	}
	
	public void preRequest(Context mainCharacter, Context enemy) { //this is the logic for attacking the enemy and updating the health
		Interceptor myInterceptor = Interceptors.get(Interceptors.size()-1);
		System.out.println("You have attacked the " + enemy.getDescription());
		enemy.setHealth(enemy.getHealth() - mainCharacter.getDamage()); //enemy context is updated
		myInterceptor.preRequest(mainCharacter, enemy);//calls the prerequest for the interceptor
		
		
	}

	public void postRequest(Context mainCharacter, Context enemy) {
		Interceptor myInterceptor = Interceptors.get(Interceptors.size()-1);
		mainCharacter.setHealth(mainCharacter.getHealth() - enemy.getDamage());//updating the context
		System.out.println(mainCharacter.getDescription()+" Finished attacking");
		myInterceptor.postRequest(mainCharacter, enemy); //after attack is finished i return the context to the interceptor to print the updates
	}

	public void registerDispatcher(Interceptor interceptor) {
		Interceptors.add(interceptor);
	}
	
	public void removerDispatcher(Interceptor interceptor) {
		Interceptors.remove(interceptor);
	}
	
	
	public static Dispatcher getInstanceOfDispatcher() {
		if(thisDispatcher == null)
			return new Dispatcher();
		else
			return thisDispatcher;
	}
	
}
