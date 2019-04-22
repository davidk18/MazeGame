package com.group4.Objects;

import com.group4.Command.GameState;
import com.group4.Command.LocalGameStateManager;
import com.group4.Command.MazeMoveCommand;
import com.group4.Interceptor.ConcreteFrameWork;
import com.group4.Interceptor.Interceptor;
import com.group4.Interfaces.MazeBuilder;
import com.group4.Interpreter.Combiner;
// fu git
public class Game {
    LocalGameStateManager gameStateManager = new LocalGameStateManager();
    CharacterPrototype character; //= new CharacterPrototype("johnathon", false, true, 100, 10, null);
    GameState game = new GameState();
    boolean exit;
    boolean mazeCreated;

    public Game() throws CloneNotSupportedException {
        exit = false;
        mazeCreated = false;
        begin();
    }

    private void begin() throws CloneNotSupportedException {
        game.setCharacter(character);
        while (!mazeCreated && !exit) {
            System.out.println();
            System.out.println("Please select type of a maze you want to create: ");
            System.out.println("U: U-shaped maze");
            System.out.println("L: L-shaped maze");
            System.out.println("H: H-shaped maze");
            System.out.println("exit: Quit game");
            String input = InputReceiver.getInput().toLowerCase();
            MazeBuilder builder;
            switch (input) {
                case "u":
                    builder = new UMazeBuilder();
                    GameSetup(builder);
                    break;
                case "l":
                    builder = new LMazeBuilder();
                    GameSetup(builder);
                    break;
                case "h":
                    builder = new HMazeBuilder();
                    GameSetup(builder);
                    break;
                case "exit":
                    exit = true;
                default:
                    System.out.println("Invalid input! Please try again...");
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
                case "attack":
                    game.attack();
                    break;
                case "undo":
                    game.undoLatestCommand();
                    break;
                case "save":
                    game = gameStateManager.save(game);
                    break;
                case "display saves":
                    gameStateManager.displaySaves();
                    break;
                case "load":
                    loadGame();
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

    private void GameSetup(MazeBuilder builder) throws CloneNotSupportedException {
        MazeCreator mazeCreator = new MazeCreator(builder);
        mazeCreator.constructMaze();
        game.setMaze(mazeCreator.getMaze());
        character = new CharacterPrototype("johnathon", false, true, 100, 10, null);
        game.setCharacter(character);
        mazeCreated = true;
        int size = game.getGameMaze().getRooms().size();
        generateTrap(size);
        generateEnemies(size, character);
    }

    private void loadGame(){
        int max = gameStateManager.getNumberOfSaves();
        System.out.println("Enter the save you wish to load");
        String userInput = InputReceiver.getInput().toLowerCase();
        int selectedSave = 0;
        try{
            selectedSave = Integer.parseInt(userInput);
        }
        catch (Exception e){
            System.out.println("Please enter an integer");
        }
        if (selectedSave < max){
            game.getCharacter().setCurrentRoom(game.getGameMaze().getRooms().get(0));
            game = gameStateManager.load(selectedSave);
        }



    }

    public void generateTrap(int size)
    {
        int sizeOfRooms = size;
        //System.out.println("num of total rooms: " + sizeOfRooms);
        int randomNum = (int) (Math.random() * sizeOfRooms-1);
        if(randomNum == 0) {
            System.out.println("Tread carefully there is a trap generated in this room");
        }

        int trapSelection = (int)(Math.random() * 3);
        if(trapSelection == 0) {
            trapBuilder trap1 = new trapBuilder.Builder().setDescription("this trap covers any poor soul who stumbles upon it in flames").setTrapActive(true).setHasFire(true).build();
            // System.out.println("trap1: " + trap1.getDescription());
            game.getGameMaze().getRooms().get(randomNum).addTrap(trap1);
            //System.out.println("trap added to room: " + randomNum + "trap added is: " + trap1.getDescription());
        }
        else if(trapSelection == 1){
            trapBuilder trap1 = new trapBuilder.Builder().setDescription("this trap has pressure sensors that have been signaled and just shot spikes on the character that took the wrong step").setTrapActive(true).setHasSpikes(true).build();
            game.getGameMaze().getRooms().get(randomNum).addTrap(trap1);
            //System.out.println("trap added to room: " + randomNum + "trap added is: " + trap1.getDescription());
        }
        else if(trapSelection == 2) {
            trapBuilder trap1 = new trapBuilder.Builder().setDescription("this trap sends 10,000 volts of electricity coarsing through the misfortunate characters body").setTrapActive(true).setHasElectrified(true).build();
            game.getGameMaze().getRooms().get(randomNum).addTrap(trap1);
            //System.out.println("trap added to room: " + randomNum + "trap added is: " + trap1.getDescription());
        }
        else{
            System.out.print("no trap inserted this time around.");
        }
    }

    public void generateEnemies(int size, CharacterPrototype original) throws CloneNotSupportedException
    {
        int sizeOfRooms = size;
        //System.out.println("num of total rooms: " + sizeOfRooms);
        int randomNum = (int) (Math.random() * sizeOfRooms-1);

        int enemySelection = (int)(Math.random() * 3);

        //Clone and Modify what is required
        CharacterPrototype clonedZombie = original.clone();
        clonedZombie.setDescription("zombie");
        clonedZombie.setEnemy(true);
        clonedZombie.setDamage(8);
        //System.out.println("clonedZombie name: " + clonedZombie.getDescription() + "clonedZombie damage " + clonedZombie.getDamage() + " health: " +   clonedZombie.getHealth());

        CharacterPrototype clonedThief = clonedZombie.clone();
        clonedThief.setDescription("Thief");
        clonedThief.setDamage(12);
        // System.out.println("clonedThief name: " + clonedThief.getDescription() + "clonedThief damage " + clonedThief.getDamage() + " health: " +   clonedThief.getHealth());

        CharacterPrototype clonedNinja = clonedZombie.clone();
        clonedNinja.setDescription("Ninja");
        clonedNinja.setDamage(15);
        //System.out.println("clonedNinja name: " + clonedNinja.getDescription() + "clonedNinja damage " + clonedNinja.getDamage() + " health: " +   clonedNinja.getHealth());

        if(enemySelection == 0)
        {
            game.getGameMaze().getRooms().get(randomNum).addEnemy(clonedZombie);
        }
        else if(enemySelection == 1)
        {
            game.getGameMaze().getRooms().get(randomNum).addEnemy(clonedThief);
        }
        else if(enemySelection == 2)
        {
            game.getGameMaze().getRooms().get(randomNum).addEnemy(clonedNinja);
        }

    }
}
