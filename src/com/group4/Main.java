package com.group4;

import com.group4.Factory.SimpleWeaponFactory;
import com.group4.Factory.WeaponFactory;
import com.group4.Interfaces.Weapon;
import com.group4.Objects.*;
import com.group4.Interceptor.ConcreteFrameWork;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
//        TestCode();
        MazeGame game = new MazeGame();
        Maze maze = game.createMaze();
        CharacterPrototype original = new CharacterPrototype("johnathon", false, true, 100, 10);
        original.setCurrentRoom(maze.getRooms().get(0));
        boolean exit = false;
        while(!exit) {
            System.out.println();
            System.out.println(original.getDescription() + " is currently in " + original.getCurrentRoom());
            String input = getInput();
            switch (input) {
                case "go north":
                    move(original, Direction.North);
                    break;
                case "go south":
                    move(original, Direction.South);
                    break;
                case "go west":
                    move(original, Direction.West);
                    break;
                case "go east":
                    move(original, Direction.East);
                    break;
                case "exit":
                    exit = true;
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }

    }

    private static void move(CharacterPrototype original, Direction direction) {
        try {
            Door door = (Door) original.getCurrentRoom().getSide(direction);
            if(door.getRoom1().equals(original.getCurrentRoom())) {
                original.setCurrentRoom(door.getRoom2());
            }
            else
            {
                original.setCurrentRoom(door.getRoom1());
            }
        } catch (ClassCastException e) {
            System.out.println("You tried to walk through a wall!");
        }
    }


    private static String getInput() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        return input;
    }

    private static void TestCode() throws CloneNotSupportedException {
        MazeGame game = new MazeGame();
        Maze maze = game.createMaze();

        SimpleWeaponFactory simpleFactory = new SimpleWeaponFactory();
        WeaponFactory factory = simpleFactory.getWeaponFactory("Gold");
        Weapon gun = factory.getWeapon("Sword");
        System.out.println(gun.getLongDescription());
        System.out.println(gun.getDamage());


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
