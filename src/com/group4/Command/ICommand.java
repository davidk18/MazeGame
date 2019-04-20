package com.group4.Command;

import com.group4.Objects.Direction;

public interface ICommand {

    public void execute();

    public void execute(Direction direction);

    public void undo();

    public void setDirection();

    public Direction getDirection();

}
