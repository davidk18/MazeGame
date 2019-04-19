//package com.group4.Objects;
//
//import com.group4.Factory.MazeFactory;
//import com.group4.Interfaces.Maze;
//
//import java.util.*;
//
//public class MazeGame {
//
//
//    private MazeFactory factory;
//
//    public Maze createMaze() {
//        createFactory();
//        Maze aMaze = factory.makeMaze();
//        Room r1 = factory.makeRoom();
//        Room r2 = factory.makeRoom();
//        Door theDoor = factory.makeDoor(r1,r2);
//        aMaze.addRoom(r1); aMaze.addRoom(r2);
//        r1.setSide(Direction.North, factory.makeWall());
//        r1.setSide(Direction.East, theDoor);
//        r1.setSide(Direction.South, factory.makeWall());
//        r1.setSide(Direction.West, factory.makeWall());
//        r2.setSide(Direction.North, factory.makeWall());
//        r2.setSide(Direction.East, factory.makeWall());
//        r2.setSide(Direction.South, factory.makeWall());
//        r2.setSide(Direction.West, theDoor);
//        return aMaze;
//    }
//
//    public Maze generateMaze() {
//        List<Room> rooms = new ArrayList<>();
//        List<Direction> directions = new ArrayList<>();
//        directions.add(Direction.North);
//        directions.add(Direction.South);
//        directions.add(Direction.West);
//        directions.add(Direction.East);
////        Collections.shuffle(directions);
//        createFactory();
//        rooms.add(factory.makeRoom());
//        int roomNum = (int)(Math.random() * 4 + 1);
//        for(int i = 0; i < roomNum; i++) {
//            rooms.add(factory.makeRoom());
//            Door door = factory.makeDoor(rooms.get(0),rooms.get(1));
//            for(int j = 0; j < directions.size(); j++) {
//
//            }
//        }
//
//
//        return null;
//    }
//
//    private void createFactory() {
//        factory = MazeFactory.instance(); // singleton pattern
//    }
//
//}
