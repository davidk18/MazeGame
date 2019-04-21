package com.group4.Interceptor;

import java.util.ArrayList;
import com.group4.Objects.CharacterPrototype;

public class Dispatcher implements Interceptor{

	ArrayList<Interceptor> Interceptors = new ArrayList<Interceptor>();
	
	private static Dispatcher thisDispatcher;
	
	private Dispatcher() {
		
	}
	
	public void preRequest(CharacterPrototype mainCharacter) {
		Interceptor myInterceptor = Interceptors.get(Interceptors.size()-1);
		System.out.println(mainCharacter.getDescription()+" Attacked");
		myInterceptor.preRequest(mainCharacter);
		
		
	}

	public void postRequest(CharacterPrototype mainCharacter) {
		Interceptor myInterceptor = Interceptors.get(Interceptors.size()-1);
		System.out.println(mainCharacter.getDescription()+" Finished attacking");
		mainCharacter.setHealth(mainCharacter.getHealth()- 15);// i cannot set this as i cannot access the products health
		if(mainCharacter.getHealth() <= 0){
			System.out.print("you died");
			//mainCharacter.isAlive() = false;
		}
		myInterceptor.postRequest(mainCharacter);
	}

	public void registerDispatcher(Interceptor interceptor) {
		Interceptors.add(interceptor);
		//System.out.println("You have attacked.");
	}
	
	public void removerDispatcher(Interceptor interceptor) {
		Interceptors.remove(interceptor);
		//System.out.println("Your attack is over.");
	}
	
	
	public static Dispatcher getInstanceOfDispatcher() {
		if(thisDispatcher == null)
			return new Dispatcher();
		else
			return thisDispatcher;
	}
	
}
