package com.group4;

import com.group4.Command.GameState;
import com.group4.Command.LocalGameStateManager;
import com.group4.Command.MazeMoveCommand;
import com.group4.Factory.SimpleWeaponFactory;
import com.group4.Factory.WeaponFactory;
import com.group4.Interfaces.IMaze;
import com.group4.Interfaces.MazeBuilder;
import com.group4.Interfaces.Weapon;
import com.group4.Interpreter.Combiner;
import com.group4.Objects.*;
import com.group4.Interceptor.ConcreteFrameWork;

import java.util.Scanner;

public class Main {

    private Maze maze;

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



        LocalGameStateManager gameStateManager = new LocalGameStateManager();
        GameState game = new GameState();
        CharacterPrototype character;
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
                    game.setMaze(mazeCreator.getMaze());
                    character = new CharacterPrototype("johnathon", false, true, 100, 10, null);
                    game.setCharacter(character);
                    mazeCreated = true;
                    break;
                 default:
                     exit = true;
                break;
            }
        }
        if(!exit) {
            game.getCharacter().setCurrentRoom(game.getGameMaze().getRooms().get(0));
        }
        while(!exit) {
            System.out.println();
            System.out.println(game.getCharacter().getDescription() + " is currently in " + game.getCharacter().getCurrentRoom());
            System.out.println(game.getGameMaze().getMap(game.getCharacter().getCurrentRoom()));
            String input = getInput().toLowerCase();
            switch (input) {
                case "go north":
                    game.getCharacter().setDirectionChosen(Direction.North);
                    game.addAction(new MazeMoveCommand(game.getGameMaze(), game.getCharacter()));
                    game.executeLatestCommand();
                    break;
                case "go south":
                    game.getCharacter().setDirectionChosen(Direction.South);
                    game.addAction(new MazeMoveCommand(game.getGameMaze(), game.getCharacter()));
                    game.executeLatestCommand();
                    break;
                case "go west":
                    game.getCharacter().setDirectionChosen(Direction.West);
                    game.addAction(new MazeMoveCommand(game.getGameMaze(), game.getCharacter()));
                    game.executeLatestCommand();
                    break;
                case "go east":
                    game.getCharacter().setDirectionChosen(Direction.East);
                    game.addAction(new MazeMoveCommand(game.getGameMaze(), game.getCharacter()));
                    game.executeLatestCommand();
                    break;
                case "undo last":
                    game.undoLatestCommand();
                    break;
                case "save game":
                    game = gameStateManager.save(game);
                    break;
                case "display saves":
                    gameStateManager.displaySaves();
                    break;
                case "1":
                    game.getCharacter().setCurrentRoom(game.getGameMaze().getRooms().get(0));
                    gameStateManager.load(1);
                    break;
                case "combine":
                    Combiner combiner = new Combiner();
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

        CharacterPrototype original = new CharacterPrototype("johnathon", false, true, 100, 10, null);
        System.out.println(original.getDescription());

        //Clone and Modify what is required
        CharacterPrototype cloned = original.clone();
        cloned.setDescription("billy ray cyrus");
        cloned.setAlive(true);
        cloned.setDamage(30);
        cloned.setEnemy(true);
        System.out.println("clone name: " + cloned.getDescription() + "clone damage " + cloned.getDamage() +  cloned.getHealth());
        ConcreteFrameWork.attack(original);

        //test builder for trap
//        trapBuilder trap1 = new trapBuilder.Builder().setDescription("this trap covers any poor soul who stumbles upon it in flames").setTrapActive(true).setHasFire(true).build();
//        System.out.println("trap1: " + trap1);
//        System.out.println(trap1.getDescription());


    }
}
