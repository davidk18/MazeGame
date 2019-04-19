package com.group4.Interfaces;

import com.group4.Objects.Room;

import java.util.ArrayList;
import java.util.List;

public interface IMaze {
    void addRoom(Room r);
    List<Room> getRooms();
}
