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

    public int getMoves(){
        return gameBoard.getMoves();
    }

    public void setField(int x, int y, char a){
        gameBoard.setField(x,y,a);
    }

    public int[] parsingToGB(int x) {
        switch (x){
            case 1:
                return new int[] {0,0};
            case 2:
                return new int[] {0,1};
            case 3:
                return new int[] {0,2};
            case 4:
                return new int[] {1,0};
            case 5:
                return new int[] {1,1};
            case 6:
                return new int[] {1,2};
            case 7:
                return new int[] {2,0};
            case 8:
                return new int[] {2,1};
            case 9:
                return new int[] {2,2};
            default:
                return new int[] {};
        }
    }
}
