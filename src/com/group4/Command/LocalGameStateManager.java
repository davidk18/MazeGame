package com.group4.Command;

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
            if (state.getActions().get(i) instanceof MazeMoveCommand) {
                state.getActions().get(i).execute(state.getActions().get(i).getDirection());
            }
            else {
                state.getActions().get(i).execute();
            }


        }
        return state;

    }

    public GameState getGameState(int saveId){
        return gameStates.get(saveId-1);
    }

    public int getNumberOfSaves(){
        return gameStates.size();
    }

}
