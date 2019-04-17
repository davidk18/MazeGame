package com.group4.Interceptor;

import com.group4.Objects.CharacterPrototype;

public class ConcreteFrameWork {

	public static void attack(CharacterPrototype mainCharacter) { // should be the attack has to be in the main file as this ill start th interceptor
		
		Dispatcher myDispatcher = Dispatcher.getInstanceOfDispatcher();  // create dispatcher singleton

		AttackSequence userAttack = new AttackSequence(); //this will be the attack sequence


		userAttack.checkHealthBefore(mainCharacter, myDispatcher); //context needs to be the main character

		userAttack.checkHealthAfter(mainCharacter, myDispatcher);
		
	}

}
