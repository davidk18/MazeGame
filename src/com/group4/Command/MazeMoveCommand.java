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

        //System.out.println("current room trap: " + original.getCurrentRoom().getTrap());
        //code for traps
        if(original.getCurrentRoom().getTrap() != null)
        {
            System.out.println("health before trap: " + original.getHealth());
            System.out.println("you have been damaged by the trap: " + original.getCurrentRoom().getTrap().getDescription());

            if(original.getCurrentRoom().getTrap().isHasFire() == true)
            {
                original.setHealth(original.getHealth() - original.getCurrentRoom().getTrap().getDamage());
                System.out.println("new health: " + original.getHealth());
            }
            else if(original.getCurrentRoom().getTrap().isHasSpikes() == true)
            {
                original.setHealth(original.getHealth() - original.getCurrentRoom().getTrap().getDamage());
                System.out.println("new health: " + original.getHealth());
            }
            else if(original.getCurrentRoom().getTrap().isHasElectrified() == true)
            {
                original.setHealth(original.getHealth() - original.getCurrentRoom().getTrap().getDamage());
                System.out.println("new health: " + original.getHealth());
            }
        }
        else{
            System.out.println("you have NOT been damaged by the trap");
        }

        //code for enemies
        if(original.getCurrentRoom().getEnemy() != null) {
            if (original.getCurrentRoom().getEnemy().getDescription() == "zombie") {
                System.out.println("Theres an emeny in this room ");
                System.out.println("Enemy name: " + original.getCurrentRoom().getEnemy().getDescription() + "\n Enemy damage: " + original.getCurrentRoom().getEnemy().getDamage() + "\n Enemy health: " +   original.getCurrentRoom().getEnemy().getHealth());
            } else if (original.getCurrentRoom().getEnemy().getDescription() == "Thief") {
                System.out.println("Theres an emeny in this room ");
                System.out.println("Enemy name: " + original.getCurrentRoom().getEnemy().getDescription() + "\n Enemy damage: " + original.getCurrentRoom().getEnemy().getDamage() + "\n Enemy health: " +   original.getCurrentRoom().getEnemy().getHealth());
            } else if (original.getCurrentRoom().getEnemy().getDescription() == "Ninja") {
                System.out.println("Theres an emeny in this room ");
                System.out.println("Enemy name: " + original.getCurrentRoom().getEnemy().getDescription() + "\n Enemy damage: " + original.getCurrentRoom().getEnemy().getDamage() + "\ngo Enemy health: " +   original.getCurrentRoom().getEnemy().getHealth());
            } else {
                System.out.println("No enemies present in this room ");
            }
        }else {
            System.out.println("No enemies present in this room ");
        }
    }

    public void execute(Direction direction){
        maze.move(original, direction);
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

    public void setDirection(){
        this.direction = direction;
    }

    public Direction getDirection(){
        return direction;
    }
}
