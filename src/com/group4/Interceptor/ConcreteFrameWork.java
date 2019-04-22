package com.group4.Interceptor;

import com.group4.Objects.CharacterPrototype;

public class ConcreteFrameWork {

	public static void attack(CharacterPrototype mainCharacter, CharacterPrototype enemy) { //this will start the interceptor
		Dispatcher myDispatcher = Dispatcher.getInstanceOfDispatcher();  // create dispatcher singleton

		AttackSequence userAttack = new AttackSequence(); //this will be the attack sequence


		userAttack.checkHealthBefore(mainCharacter, enemy, myDispatcher);

		userAttack.checkHealthAfter(mainCharacter, enemy, myDispatcher);
		
	}

}
