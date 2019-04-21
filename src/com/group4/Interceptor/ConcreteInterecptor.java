package com.group4.Interceptor;

import java.util.ArrayList;
import com.group4.Objects.CharacterPrototype;

public class ConcreteInterecptor implements Interceptor{

	
	ArrayList<String> HealthBefore = new ArrayList<String>();
	ArrayList<String> HealthAfter = new ArrayList<String>();
	
	private static ConcreteInterecptor myInterceptorAction;
	
	private ConcreteInterecptor() {
		
	}
	
	public void preRequest(CharacterPrototype mainCharacter, CharacterPrototype enemy) {
		System.out.println(mainCharacter.getDescription()+"'s health before he attacked is: "+mainCharacter.getHealth());
		HealthBefore.add(mainCharacter.getDescription()+"\t"+mainCharacter.getHealth());
	}

	public void postRequest(CharacterPrototype mainCharacter, CharacterPrototype enemy) {
		System.out.println("You did " + mainCharacter.getDamage() + " damage to the " + enemy.getDescription());
		System.out.println("The " + enemy.getDescription()+"'s health after you attacked is: "+enemy.getHealth());
		System.out.println("The " + enemy.getDescription()+" did " + enemy.getDamage() + " damage to you,");
		System.out.println("Your health after attacking is: " + mainCharacter.getHealth());
		HealthAfter.add(mainCharacter.getDescription()+"\t" + mainCharacter.getHealth());
	}
	

	public static ConcreteInterecptor getInstanceOfInterceptorAction() {
		if(myInterceptorAction == null) 
			return new ConcreteInterecptor();
		else
			return myInterceptorAction;
	}
	
	
}
