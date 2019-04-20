package com.group4.Command;

public interface IGameStateManager {

    void displaySaves();
    GameState load(int saveId);
    GameState save(GameState state);
    GameState newGame(int saveId);

}
