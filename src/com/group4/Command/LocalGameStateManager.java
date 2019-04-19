package com.group4.Command;

import java.util.ArrayList;

public class LocalGameStateManager implements IGameStateManager {

    ArrayList<GameState> gameStates = new ArrayList<GameState>();

    public void load(GameState state){
    }

    public void save(GameState state){
        gameStates.add(state);
    }
}
