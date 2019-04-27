package com.group4.Interceptor;

import com.group4.Prototype.CharacterPrototype;

public class ConcreteFrameWork {

	public static void attack(CharacterPrototype mainCharacter, CharacterPrototype enemy) { //this will start the Interceptor
		Dispatcher myDispatcher = Dispatcher.getInstanceOfDispatcher();  // create dispatcher singleton

		AttackSequence userAttack = new AttackSequence(); // this is creating the attack sequence which is the application

		//userAttack.checkHealthBefore(mainCharacter, enemy, myDispatcher); //calling the checkHealthBefore method and passing the context
		//userAttack.checkHealthAfter(mainCharacter, enemy, myDispatcher); //health check after the attack

		Context player = new Context(mainCharacter.getHealth(),mainCharacter.getDescription(), mainCharacter.getDamage(), mainCharacter.isAlive());
		Context badguy = new Context(enemy.getHealth(), enemy.getDescription(), enemy.getDamage(),enemy.isAlive());

		userAttack.checkHealthBefore(player, badguy, myDispatcher);
		userAttack.checkHealthAfter(player, badguy, myDispatcher);

		mainCharacter.setHealth(player.getHealth());
		//System.out.println("here");
		enemy.setHealth(badguy.getHealth());
		enemy.setAlive(badguy.isAlive());
		if(enemy.isAlive() == false){
			System.out.println("here1");
			mainCharacter.getCurrentRoom().removeEnemy();
		}
		//System.out.println("here2");
	}

}
