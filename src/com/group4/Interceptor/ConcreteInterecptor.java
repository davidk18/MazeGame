package com.group4.Interceptor;

import java.util.ArrayList;

public class ConcreteInterecptor implements Interceptor{

	
	ArrayList<String> HealthBefore = new ArrayList<String>();
	ArrayList<String> HealthAfter = new ArrayList<String>();
	
	private static ConcreteInterecptor myInterceptorAction;
	
	private ConcreteInterecptor() {
		
	}
	
	public void preRequest(Context mainCharacter, Context enemy) {
		System.out.println(mainCharacter.getDescription()+"'s health before he attacked is: "+mainCharacter.getHealth());
		HealthBefore.add(mainCharacter.getDescription()+"\t"+mainCharacter.getHealth());//adds the health before attack to the health before attack
	}

	public void postRequest(Context mainCharacter, Context enemy) {
		System.out.println("You did " + mainCharacter.getDamage() + " damage to the " + enemy.getDescription());
		System.out.println("The " + enemy.getDescription()+"'s health after you attacked is: "+enemy.getHealth());
        if(enemy.getHealth() <= 0){
        	enemy.setAlive(false);
            System.out.println("You killed the " + enemy.getDescription());
        }
		System.out.println("The " + enemy.getDescription()+" did " + enemy.getDamage() + " damage to you,");
		if(mainCharacter.getHealth() <= 0){
			System.out.print("You died, game over");// game should end here
			System.exit(0);//one way to end not the best
		}
		else System.out.println("Your health after attacking is: " + mainCharacter.getHealth());

		HealthAfter.add(mainCharacter.getDescription()+"\t" + mainCharacter.getHealth());
	}
	

	public static ConcreteInterecptor getInstanceOfInterceptorAction() {
		if(myInterceptorAction == null) 
			return new ConcreteInterecptor();
		else
			return myInterceptorAction;
	}
	
	
}
