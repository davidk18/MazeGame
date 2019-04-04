package com.group4.Factory;

import com.group4.Objects.Door;
import com.group4.Objects.Maze;
import com.group4.Objects.Room;
import com.group4.Objects.Wall;

public class MazeFactory {

    private MazeFactory(){ }
        // method for returning the unique instance of MazeFactory
    public static MazeFactory instance(){
        if (_theFactory == null){
            _theFactory = new MazeFactory();
        }
        return _theFactory;
    }

    public Maze makeMaze(){ return new Maze(); }
    public Wall makeWall(){ return new Wall(); }
    public Room makeRoom(){ return new Room(); }
    public Door makeDoor(Room r1, Room r2){
        return new Door(r1,r2);
    }

    private static MazeFactory _theFactory = null;

}
