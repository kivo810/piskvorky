package cz.ucl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameBoardService {
    @Autowired
    GameBoard gameBoard;

    public char[][] getGame(){
        return gameBoard.getBoard();
    }

    public void refreshGame(){
        gameBoard.refreshBoard();
    }

    public char getField(int x, int y){
        return gameBoard.getField(x, y);
    }

    public void setField(int x, int y){
        gameBoard.setField(x,y);
    }
}
