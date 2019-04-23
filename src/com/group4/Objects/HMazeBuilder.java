package com.group4.Objects;

import com.group4.Interfaces.MazeBuilder;

public class HMazeBuilder implements MazeBuilder {

    private Maze maze;

    @Override
    public void buildMaze() {
        maze = new Maze(buildMap());
    }

    @Override
    public void buildRooms() {
        Door d1 = new Door();
        Door d2 = new Door();
        Door d3 = new Door();
        Door d4 = new Door();
        Room r1 = new Room.Builder(d4, d3, d1, d2).addItemsToRoom(ItemRandomiser.assignItems()).build(); // room 1
        maze.addRoom(r1);
        Room r2 = new Room.Builder(new Wall(), new Wall(), new Wall(), d1).addItemsToRoom(ItemRandomiser.assignItems()).build(); // 2
        maze.addRoom(r2);
        d1.setRooms(r1, r2);



        r2 = new Room.Builder(new Wall(), new Wall(), d2, new Wall()).addItemsToRoom(ItemRandomiser.assignItems()).build(); // 3
        maze.addRoom(r2);
        d2.setRooms(r1, r2);

        d1 = new Door();
        d2 = new Door();
        r2 = new Room.Builder(d3, new Wall(), d1, d2).addItemsToRoom(ItemRandomiser.assignItems()).build(); // 4
        maze.addRoom(r2);
        d3.setRooms(r1, r2);


        Room r3 = r2;
        r2 = new Room.Builder(new Wall(), new Wall(), new Wall(), d1).addItemsToRoom(ItemRandomiser.assignItems()).build(); // 5
        maze.addRoom(r2);
        d1.setRooms(r3, r2);

        r2 = new Room.Builder(new Wall(), new Wall(), d2, new Wall()).addItemsToRoom(ItemRandomiser.assignItems()).build(); // 6
        maze.addRoom(r2);
        d2.setRooms(r3, r2);


        d1 = new Door();
        d2 = new Door();
        r1 = maze.getRooms().get(0);
        r2 = new Room.Builder(new Wall(), d4, d1, d2).addItemsToRoom(ItemRandomiser.assignItems()).build(); // 7
        maze.addRoom(r2);
        d4.setRooms(r1, r2);

        r1 = r2;
        r2 = new Room.Builder(new Wall(), new Wall(), new Wall(), d1).addItemsToRoom(ItemRandomiser.assignItems()).build(); // 8
        maze.addRoom(r2);
        d1.setRooms(r1, r2);

        r2 = new Room.Builder(new Wall(), new Wall(), d2, new Wall()).addItemsToRoom(ItemRandomiser.assignItems()).build();// 9
        maze.addRoom(r2);
        d2.setRooms(r1, r2);

    }

    @Override
    public String buildMap() {
        String map = "";
		map += "[8] --- [7] --- [9]\n";
		map += "         |         \n";
		map += "         |         \n";
		map += "[2] --- [1] --- [3]\n";
		map += "         |         \n";
		map += "         |         \n";
		map += "[5] --- [4] --- [6]\n"; // --- [j]\n";
        return map;
    }

    @Override
    public Maze getMaze() {
        return this.maze;
    }

}
