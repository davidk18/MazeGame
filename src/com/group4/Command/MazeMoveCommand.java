package com.group4.Command;

import com.group4.Objects.CharacterPrototype;
import com.group4.Objects.Direction;
import com.group4.Objects.Door;
import com.group4.Objects.Maze;

public class MazeMoveCommand implements ICommand{

    protected Maze maze;
    protected Direction direction;
    protected CharacterPrototype original;

    public MazeMoveCommand(Maze maze, CharacterPrototype original){
        this.maze = maze;
        this.direction = original.getDirectionChosen();
        this.original = original;
    }

    public void execute(){
        maze.move(original);
    }

    public void undo(){
        switch (direction.toString()) {
            case "North":
                original.setDirectionChosen(Direction.South);
                maze.move(original);
                break;
            case "South":
                original.setDirectionChosen(Direction.North);
                maze.move(original);
                break;
            case "East":
                original.setDirectionChosen(Direction.West);
                maze.move(original);
                break;
            case "West":
                original.setDirectionChosen(Direction.East);
                maze.move(original);
                break;
        }
    }
}
