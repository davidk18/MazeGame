package com.group4.Command;

import com.group4.Interfaces.Item;
import com.group4.Objects.Direction;
import com.group4.Objects.InputReceiver;
import com.group4.Objects.Maze;
import com.group4.Prototype.CharacterPrototype;

public class TakeItemCommand implements ICommand {

    protected Item itemTaken;
    protected CharacterPrototype original;
    protected int itemIndex;

    public TakeItemCommand(CharacterPrototype original, int itemIndex){
        this.original = original;
        this.itemIndex = itemIndex;
    }

    @Override
    public void execute() {
        itemTaken = original.getCurrentRoom().takeItemFromRoom(itemIndex);
        original.getInventory().addItem(itemTaken);
    }

    public void execute(Direction d){
        itemTaken = original.getCurrentRoom().takeItemFromRoom(itemIndex);
        original.getInventory().addItem(itemTaken);
    }

    public void undo(){
        original.getInventory().removeItem(itemTaken);
        original.getCurrentRoom().addItemToRoom(itemTaken, itemIndex);
    }

    public Direction getDirection(){
        return null;
    }


}
