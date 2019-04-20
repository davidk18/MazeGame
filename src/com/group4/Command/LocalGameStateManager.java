package com.group4.Command;

import com.group4.Interfaces.MazeBuilder;
import com.group4.Objects.CharacterPrototype;
import com.group4.Objects.MazeCreator;
import com.group4.Objects.UMazeBuilder;

import java.util.ArrayList;

public class LocalGameStateManager implements IGameStateManager {

    ArrayList<GameState> gameStates = new ArrayList<GameState>();

    public void displaySaves(){
        System.out.println("Saved Games:");
        for (int i = 1; i <= gameStates.size(); i++){
            System.out.println(i);
        }
    }

    public GameState save(GameState state){
        gameStates.add(state);
        GameState continuedGame = new GameState(state.getGameMaze(), state.getCharacter());
        return continuedGame;
    }

    public void load(int saveId){
        MazeBuilder builder = new UMazeBuilder();
        MazeCreator mazeCreator = new MazeCreator(builder);
        mazeCreator.constructMaze();
        ArrayList<ICommand> actions = gameStates.get(saveId-1).getActions();
        CharacterPrototype c = gameStates.get(saveId-1).getCharacter();
        for (int i = 0; i < actions.size(); i++){
            actions.get(i).execute(c.getPathTaken().get(i));
        }
   }
}
