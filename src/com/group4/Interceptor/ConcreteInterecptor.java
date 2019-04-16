package com.group4.Interceptor;

import java.util.ArrayList;
import com.group4.Objects.CharacterProduct;

public class ConcreteInterecptor implements Interceptor{

	
	ArrayList<String> HealthBefore = new ArrayList<String>();
	ArrayList<String> HealthAfter = new ArrayList<String>();
	
	private static ConcreteInterecptor myInterceptorAction;
	
	private ConcreteInterecptor() {
		
	}
	
	public void preRequest(CharacterProduct mainCharacter) {
		System.out.println(mainCharacter.getDescription()+"'s health before he attacked is: "+mainCharacter.getHealth());
		HealthBefore.add(mainCharacter.getDescription()+"\t"+mainCharacter.getHealth());
	}

	public void postRequest(CharacterProduct mainCharacter) {
		System.out.println(mainCharacter.getDescription()+"'s health after attacking is: "+mainCharacter.getHealth());
		HealthAfter.add(mainCharacter.getDescription()+"\t"+mainCharacter.getHealth());
	}
	

	public static ConcreteInterecptor getInstanceOfInterceptorAction() {
		if(myInterceptorAction == null) 
			return new ConcreteInterecptor();
		else
			return myInterceptorAction;
	}
	
	
}
