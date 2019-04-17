package com.group4;

import com.group4.Factory.GoldWeaponFactory;
import com.group4.Factory.WeaponFactory;
import com.group4.Objects.*;
import com.group4.Interfaces.Shotgun;
import com.group4.Interfaces.Sword;
import com.group4.Interceptor.ConcreteFrameWork;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        MazeGame game = new MazeGame();
        Maze maze = game.createMaze();

        WeaponFactory factory = new GoldWeaponFactory();
        Shotgun gun = factory.getShotgun();
        System.out.println(gun.getLongDescription());

        Sword sword = factory.getSword();
        System.out.println(sword.getDamage());

        CharacterProduct mainCharacter = new CharacterProduct.Builder().setDescription("tyrese").setHealth(100).setAlive(true).build();
        CharacterProduct enemy = new CharacterProduct.Builder().setEnemy(true).setAlive(true).setHealth(100).setDamage(50).build();

        System.out.println("enemy health " + enemy.getHealth());
        System.out.println("enemy damage " + enemy.getDamage());
        System.out.println("enemy isAlive? " + enemy.isAlive());
        System.out.println("enemy isEnemy? " + enemy.isEnemy());

        System.out.println("main characters name: " + mainCharacter.getDescription());

        BronzeSword enchantedSword = new BronzeSword(new DoubleDamage());
        enchantedSword.enchantedDamage();

        BronzeSword godSword = new BronzeSword(new GodMode());
        godSword.enchantedDamage();
        //System.out.println(mainCharacter.setHealth(50));


        System.out.println(mainCharacter);

        CharacterPrototype original = new CharacterPrototype("johnathon", false, true, 100, 10);
        System.out.println(original.getDescription());

        //Clone and Modify what is required
        CharacterPrototype cloned = original.clone();
        cloned.setDescription("billy ray cyrus");
        cloned.setAlive(true);
        cloned.setDamage(30);
        cloned.setEnemy(true);
        System.out.println("clone name: " + cloned.getDescription() + "clone damage " + cloned.getDamage() +  cloned.getHealth());
        ConcreteFrameWork.attack(original);
    }
}
