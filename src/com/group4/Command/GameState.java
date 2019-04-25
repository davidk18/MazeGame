package com.group4.Command;

import com.group4.Interceptor.ConcreteFrameWork;
import com.group4.Prototype.CharacterPrototype;
import com.group4.Objects.Maze;

import java.util.ArrayList;

public class GameState {
    private Maze gameMaze;
    private ArrayList<ICommand> actions = new ArrayList<ICommand>();
    private CharacterPrototype character;

    public GameState(){

    }

    public GameState(Maze gameMaze, CharacterPrototype character){
        this.gameMaze = gameMaze;
        this.character = character;
    }

    public GameState(Maze gameMaze, CharacterPrototype character, ArrayList<ICommand> actions){
        this.gameMaze = gameMaze;
        this.character = character;
        this.actions = actions;
    }

    public void executeLatestCommand(){
        ICommand c = actions.get(actions.size()-1);
        System.out.println(actions.size());
        c.execute();
    }

    public void undoLatestCommand(){
        if (actions.size() > 0) {
            ICommand c = actions.get(actions.size() - 1);
            c.undo();
            actions.remove(actions.size() - 1);

        }
        else {
            System.out.println("Cannot undo");
        }
    }
    public void addAction(ICommand action){
        actions.add(action);
    }

    public void setMaze(Maze gameMaze){
        this.gameMaze = gameMaze;
    }

    public void setCharacter(CharacterPrototype character){
        this.character = character;
    }

    public CharacterPrototype getCharacter(){
        return character;
    }

    public Maze getGameMaze(){
        return gameMaze;
    }

    public ArrayList<ICommand> getActions(){
        return actions;
    }

    public void removeActions(){
        actions.clear();
    }

    public void attack(){ //Calls the concrete framework
        if(character.getCurrentRoom().getEnemy() != null) {
            ConcreteFrameWork.attack(character, character.getCurrentRoom().getEnemy());
        }
        else System.out.print("There is no enemy to attack in this room");
    }

}
