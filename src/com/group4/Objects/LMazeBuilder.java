package com.group4.Objects;

import com.group4.Interfaces.MazeBuilder;

public class LMazeBuilder implements MazeBuilder {

    private Maze maze;

    @Override
    public void buildMaze() {
        maze = new Maze(buildMap());
    }

    @Override
    public void buildRooms() {
        Door d1 = new Door();
        Door d2 = new Door();
        Room r1 = new Room.Builder(new Wall(), d1, new Wall(), new Wall()).addItemsToRoom(ItemRandomiser.assignItems()).build();// room 1
        maze.addRoom(r1);
        Room r2 = new Room.Builder(d1, d2, new Wall(), new Wall()).addItemsToRoom(ItemRandomiser.assignItems()).build(); // 2
        maze.addRoom(r2);
        d1.setRooms(r1, r2);


        d1 = d2;
        d2 = new Door();
        r1 = r2;
        r2 = new Room.Builder(d1, d2, new Wall(), new Wall()).addItemsToRoom(ItemRandomiser.assignItems()).build(); // 3
        maze.addRoom(r2);
        d1.setRooms(r1, r2);

        d1 = d2;
        d2 = new Door();
        r1 = r2;
        r2 = new Room.Builder(d1, new Wall(), new Wall(), d2).addItemsToRoom(ItemRandomiser.assignItems()).build(); // 4
        maze.addRoom(r2);
        d1.setRooms(r1, r2);

        d1 = d2;
        d2 = new Door();
        r1 = r2;
        r2 = new Room.Builder(new Wall(), new Wall(), d1, d2).addItemsToRoom(ItemRandomiser.assignItems()).build(); // 5
        maze.addRoom(r2);
        d1.setRooms(r1, r2);

        d1 = d2;
        d2 = new Door();
        r1 = r2;
        r2 = new Room.Builder(new Wall(), new Wall(), d1,  d2).addItemsToRoom(ItemRandomiser.assignItems()).build(); // 6
        maze.addRoom(r2);
        d1.setRooms(r1, r2);

        d1 = d2;
//        d2 = new Door();
        r1 = r2;
        r2 = new Room.Builder(new Wall(), new Wall(), d1, new Wall()).addItemsToRoom(ItemRandomiser.assignItems()).build(); // 7
        maze.addRoom(r2);
        d1.setRooms(r1, r2);

    }

    @Override
    public String buildMap() {
        String map = "";
        map += "[1]\n";
        map += " |\n";
        map += "[2]\n";
        map += " |\n";
        map += "[3]\n";
        map += " |\n";
        map += "[4] - [5] - [6] - [7]\n";
        return map;
    }

    @Override
    public Maze getMaze() {
        return this.maze;
    }

}
