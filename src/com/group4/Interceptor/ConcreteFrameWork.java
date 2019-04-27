package com.group4.Interceptor;

import com.group4.Prototype.CharacterPrototype;

public class ConcreteFrameWork {

	public static void attack(CharacterPrototype mainCharacter, CharacterPrototype enemy) { //this will start the Interceptor
		Dispatcher myDispatcher = Dispatcher.getInstanceOfDispatcher();  // create dispatcher singleton

		AttackSequence userAttack = new AttackSequence(); // this is creating the attack sequence which is the application

		Context player = new Context(mainCharacter.getHealth(),mainCharacter.getDescription(), mainCharacter.getDamage(), mainCharacter.isAlive());
		Context badguy = new Context(enemy.getHealth(), enemy.getDescription(), enemy.getDamage(),enemy.isAlive());

		userAttack.checkHealthBefore(player, badguy, myDispatcher);
		userAttack.checkHealthAfter(player, badguy, myDispatcher);

		mainCharacter.setHealth(player.getHealth());
		enemy.setHealth(badguy.getHealth());
		enemy.setAlive(badguy.isAlive());
		if(enemy.isAlive() == false){
			mainCharacter.getCurrentRoom().removeEnemy();
		}
	}

}
