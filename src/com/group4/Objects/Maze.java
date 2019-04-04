package com.group4.Objects;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private List<Room> rooms;

    public Maze() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }

}
