package com.group4.Objects;

import com.group4.Interfaces.MazeBuilder;

public class MazeCreator {

    private MazeBuilder builder;

    public MazeCreator(MazeBuilder builder) {
        this.builder = builder;
    }

    public Maze getMaze() {
        return this.builder.getMaze();
    }

    public void constructMaze() {
        this.builder.buildMaze();
        this.builder.buildRooms();
    }


}
