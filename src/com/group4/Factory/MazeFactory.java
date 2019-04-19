package com.group4.Factory;

import com.group4.Objects.Door;
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

    public Wall makeWall(){ return new Wall(); }
    public Door makeDoor(){ return new Door(); }

    private static MazeFactory _theFactory = null;

}
