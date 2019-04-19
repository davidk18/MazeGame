package com.group4.Objects;

import com.group4.Interfaces.MazeBuilder;

public class UMazeBuilder implements MazeBuilder {

    private Maze maze;

    @Override
    public void buildMaze() {
        maze = new Maze();
    }

    @Override
    public void buildRooms() {
        Door d1 = new Door();
        Door d2 = new Door();
        Room r1 = new Room.Builder(new Wall(), d1, new Wall(), new Wall()).build();
        maze.addRoom(r1);
        Room r2 = new Room.Builder(d1, new Wall(), new Wall(), d2).build();
        maze.addRoom(r2);
        d1.setRooms(r1, r2);


        d1 = d2;
        d2 = new Door();
        r1 = r2;
        r2 = new Room.Builder(new Wall(), new Wall(), d1, d2).build();
        maze.addRoom(r2);
        d1.setRooms(r1, r2);

        d1 = d2;
        d2 = new Door();
        r1 = r2;
        r2 = new Room.Builder(d2, new Wall(), d1, new Wall()).build();
        maze.addRoom(r2);
        d1.setRooms(r1, r2);

        d1 = d2;
//        d2 = new Door();
        r1 = r2;
        r2 = new Room.Builder(new Wall(), d1, new Wall(), new Wall()).build();
        maze.addRoom(r2);
        d1.setRooms(r1, r2);

    }

    @Override
    public Maze getMaze() {
        return this.maze;
    }

}