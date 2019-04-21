package com.group4.Command;

import com.group4.Interfaces.MazeBuilder;
import com.group4.Objects.CharacterPrototype;
import com.group4.Objects.Direction;
import com.group4.Objects.MazeCreator;
import com.group4.Objects.UMazeBuilder;

import java.util.ArrayList;
import java.util.List;

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
        ArrayList<ICommand> actions = new ArrayList<ICommand>(state.getActions());
        return new GameState(state.getGameMaze(), state.getCharacter(), actions);

 //      GameState continuedGame = new GameState(state.getGameMaze(), state.getCharacter());
   //     gameStates.add(continuedGame);

    }
//Should a gamestate handle exeecuting all of the commands for that game??
    public GameState load(int saveId){
        GameState gameToLoad = gameStates.get(saveId-1);
        ArrayList<ICommand> actions = new ArrayList<ICommand>(gameToLoad.getActions());
        GameState state = new GameState(gameStates.get(saveId-1).getGameMaze(), gameStates.get(saveId-1).getCharacter(), actions);
        for (int i = 0; i < state.getActions().size(); i++){
            state.getActions().get(i).execute(state.getActions().get(i).getDirection());
        }
        state.removeActions();
        return state;

    }

    public int getNumberOfSaves(){
        return gameStates.size();
    }

}
