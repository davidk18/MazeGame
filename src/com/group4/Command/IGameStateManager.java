package com.group4.Command;

public interface IGameStateManager {

    void displaySaves();
    void load(int saveId);
    GameState save(GameState state);

}
