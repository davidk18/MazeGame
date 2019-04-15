package com.group4;

import com.group4.Factory.GoldWeaponFactory;
import com.group4.Factory.WeaponFactory;
import com.group4.Interfaces.Shotgun;
import com.group4.Interfaces.Sword;
import com.group4.Objects.CharacterProduct;
import com.group4.Objects.Maze;
import com.group4.Objects.MazeGame;

public class Main {

    public static void main(String[] args) {
        MazeGame game = new MazeGame();
        Maze maze = game.createMaze();

        WeaponFactory factory = new GoldWeaponFactory();
        Shotgun gun = factory.getShotgun();
        System.out.println(gun.getLongDescription());

        Sword sword = factory.getSword();
        System.out.println(sword.getDamage());

        CharacterProduct mainCharacter = new CharacterProduct.Builder().setDescription("tyrese").setAlive(true).build();
        CharacterProduct enemy = new CharacterProduct.Builder().setEnemy(true).setAlive(true).setHealth(100).setDamage(50).build();

        System.out.println("enemy health " + enemy.getHealth());
        System.out.println("enemy damage " + enemy.getDamage());
        System.out.println("enemy isAlive? " + enemy.isAlive());
        System.out.println("enemy isEnemy? " + enemy.isEnemy());

        System.out.println(mainCharacter.getDescription());

    }
}
