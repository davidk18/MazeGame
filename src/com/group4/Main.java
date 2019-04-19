package com.group4;

import com.group4.Factory.SimpleWeaponFactory;
import com.group4.Factory.WeaponFactory;
import com.group4.Interfaces.IMaze;
import com.group4.Interfaces.MazeBuilder;
import com.group4.Interfaces.Weapon;
import com.group4.Objects.*;
import com.group4.Interceptor.ConcreteFrameWork;

import java.util.Scanner;

public class Main {

    private static Maze maze;

    public static void main(String[] args) throws CloneNotSupportedException {
//        TestCode();

//        A a = new A();
//        a.aText = "First text";
//        System.out.println(a.aText);
//        B b = new B();
//        b.bText = "haha";
//        b.a = a;
//        System.out.println(b.a.aText);
//        a.aText = "Test text";
//        System.out.println(a.aText);
//        System.out.println(b.a.aText);
//        a = new A();
//        a.aText = "-----------------------------";
//        b.a1 = a;
//        System.out.println(b.a.aText);
//        System.out.println(b.a1.aText);




        CharacterPrototype original = new CharacterPrototype("johnathon", false, true, 100, 10);
        boolean exit = false;
        boolean mazeCreated = false;
        while(!mazeCreated && !exit) {
            System.out.println();
            System.out.println("Please select type of a maze you want to create: ");
            System.out.println("U: U-shaped maze");
            System.out.println("L: L-shaped maze");
            System.out.println("H: H-shaped maze");
            System.out.println("exit: Quit game");
            String input = getInput().toLowerCase();
            MazeBuilder builder;
            switch (input) {
                case "u":
                    builder = new UMazeBuilder();
                    MazeCreator mazeCreator = new MazeCreator(builder);
                    mazeCreator.constructMaze();
                    maze = mazeCreator.getMaze();
                    mazeCreated = true;
                    break;
                 default:
                     exit = true;
                break;
            }
        }
        if(!exit) {
            original.setCurrentRoom(maze.getRooms().get(0));
        }
        while(!exit) {
            System.out.println();
            System.out.println(original.getDescription() + " is currently in " + original.getCurrentRoom());
            String input = getInput().toLowerCase();
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
//        MazeGame game = new MazeGame();
//        Maze maze = game.createMaze();

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
