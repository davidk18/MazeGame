package com.group4.Objects;

import com.group4.Interfaces.MazeBuilder;

public class UMazeBuilder implements MazeBuilder {

    private Maze maze;

    @Override
    public void buildMaze() {
        maze = new Maze(buildMap());
    }

    @Override
    public void buildRooms() {
        Door d1 = new Door();
        Door d2 = new Door();
        //Room r1 = new Room.Builder(new Wall(), d1, new Wall(), new Wall()).addItemsToRoom(ItemRandomiser.assignItems()).build();
        Room r1 = new Room.Builder().setNorth(new Wall()).setSouth(d1).setWest(new Wall()).setEast(new Wall()).addItemsToRoom(ItemRandomiser.assignItems()).build();
        maze.addRoom(r1);
        //Room r2 = new Room.Builder(d1, new Wall(), new Wall(), d2).addItemsToRoom(ItemRandomiser.assignItems()).build();
        Room r2 = new Room.Builder().setNorth(d1).setSouth(new Wall()).setWest(new Wall()).setEast(d2).addItemsToRoom(ItemRandomiser.assignItems()).build();
        maze.addRoom(r2);
        d1.setRooms(r1, r2);


        d1 = d2;
        d2 = new Door();
        r1 = r2;
//        r2 = new Room.Builder(new Wall(), new Wall(), d1, d2).addItemsToRoom(ItemRandomiser.assignItems()).build();
        r2 = new Room.Builder().setNorth(new Wall()).setSouth(new Wall()).setWest(d1).setEast(d2).addItemsToRoom(ItemRandomiser.assignItems()).build();

        maze.addRoom(r2);
        d1.setRooms(r1, r2);

        d1 = d2;
        d2 = new Door();
        r1 = r2;
//        r2 = new Room.Builder(d2, new Wall(), d1, new Wall()).addItemsToRoom(ItemRandomiser.assignItems()).build();
        r2 = new Room.Builder().setNorth(d2).setSouth(new Wall()).setWest(d1).setEast(new Wall()).addItemsToRoom(ItemRandomiser.assignItems()).build();
        maze.addRoom(r2);
        d1.setRooms(r1, r2);

        d1 = d2;
        r1 = r2;
//        r2 = new Room.Builder(new Wall(), d1, new Wall(), new Wall()).addItemsToRoom(ItemRandomiser.assignItems()).build();
        r2 = new Room.Builder().setNorth(new Wall()).setSouth(d1).setWest(new Wall()).setEast(new Wall()).addItemsToRoom(ItemRandomiser.assignItems()).build();
        maze.addRoom(r2);
        d1.setRooms(r1, r2);

    }

    @Override
    public String buildMap() {
        String map = "";
        map += "[1]     [5]\n";
        map += " |       |\n";
        map += "[2]-[3]-[4]\n";
        return map;
    }

    @Override
    public Maze getMaze() {
        return this.maze;
    }

}
