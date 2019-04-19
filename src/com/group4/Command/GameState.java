package com.group4.Command;

import com.group4.Objects.Maze;

import javax.swing.*;
import java.util.ArrayList;

public class GameState {
    private static int gameId = 0;
    private Maze gameStateMaze;
    private ArrayList<ICommand> actions = new ArrayList<ICommand>();

    public GameState(Maze gameStateMaze){
        this.gameStateMaze = gameStateMaze;
        gameId++;
    }

    public void executeLatestCommand(){
        ICommand c = actions.get(actions.size()-1);
        System.out.println(actions.size());
        c.execute();
    }

    public void undoLatestCommand(){
        System.out.println("test");
        ICommand c = actions.get(actions.size()-1);
        c.undo();
        actions.remove(c);
    }

    public void addAction(MazeMoveCommand action){
        actions.add(action);
    }

    public ArrayList<ICommand> getActions(){
        return actions;
    }
}
