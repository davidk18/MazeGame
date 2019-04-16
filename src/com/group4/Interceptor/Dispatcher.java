package com.group4.Interceptor;

import java.util.ArrayList;
import com.group4.Objects.CharacterProduct;

public class Dispatcher implements Interceptor{

	ArrayList<Interceptor> Interceptors = new ArrayList<Interceptor>();
	
	private static Dispatcher thisDispatcher;
	
	private Dispatcher() {
		
	}
	
	public void preRequest(CharacterProduct mainCharacter) {
		Interceptor myInterceptor = Interceptors.get(Interceptors.size()-1);
		System.out.println(mainCharacter.getDescription()+" Attacked");
		myInterceptor.preRequest(mainCharacter);
		
		
	}

	public void postRequest(CharacterProduct mainCharacter) {
		Interceptor myInterceptor = Interceptors.get(Interceptors.size()-1);
		System.out.println(mainCharacter.getDescription()+" Finished attacking");
		//mainCharacter.setHealth(50); i cannot set this as i cannot access the products health 
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
