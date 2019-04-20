package com.group4.Objects;

import com.group4.Command.GameState;
import com.group4.Command.LocalGameStateManager;
import com.group4.Command.MazeMoveCommand;
import com.group4.Interfaces.MazeBuilder;
import com.group4.Interpreter.Combiner;

public class Game {
    LocalGameStateManager gameStateManager = new LocalGameStateManager();
    CharacterPrototype character = new CharacterPrototype("johnathon", false, true, 100, 10, null);
    boolean exit;
    boolean mazeCreated;

    public Game(){
        exit = false;
        mazeCreated = false;
        begin();
    }

    private void begin() {
        GameState game = new GameState();
        LocalGameStateManager gameStateManager = new LocalGameStateManager();
        CharacterPrototype character = new CharacterPrototype("johnathon", false, true, 100, 10, null);
        game.setCharacter(character);

        while (!mazeCreated && !exit) {
            System.out.println();
            System.out.println("Please select type of a maze you want to create: ");
            System.out.println("U: U-shaped maze");
            System.out.println("L: L-shaped maze");
            System.out.println("H: H-shaped maze");
            System.out.println("exit: Quit game");
            String input = InputReceiver.getInput().toLowerCase();
            switch (input) {
                case "u":
                    MazeBuilder builder;

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
            game.getCharacter().setCurrentRoom(game.getGameMaze().getRooms().get(0));

        }

        while(!exit) {
            System.out.println();
            System.out.println(game.getCharacter().getDescription() + " is currently in " + game.getCharacter().getCurrentRoom());
            System.out.println(game.getGameMaze().getMap(game.getCharacter().getCurrentRoom()));
            String userInput = InputReceiver.getInput().toLowerCase();
            switch (userInput) {
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
                    game = gameStateManager.load(1);
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
}
