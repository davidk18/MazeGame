package com.group4.Interfaces;

import com.group4.Objects.Maze;

public interface MazeBuilder {
    void buildMaze();
    void buildRooms();
    String buildMap();
    Maze getMaze();
}
