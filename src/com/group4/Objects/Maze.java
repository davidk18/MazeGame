package com.group4.Objects;

import com.group4.Interfaces.IMaze;

import java.util.ArrayList;
import java.util.List;

public class Maze implements IMaze {

    private List<Room> rooms;

    public Maze() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room r) {
        rooms.add(r);
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
