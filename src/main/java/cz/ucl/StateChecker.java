package cz.ucl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StateChecker implements IStateChecker {

    @Autowired
    GameBoardService gameBoardService;

    @Override
    public boolean checkWinner(GameBoard gameBoard, char x) {
        if (((gameBoard.getField(0,0) == x) && (gameBoard.getField(0,1) == x) && (gameBoard.getField(0,2) == x))||
                ((gameBoard.getField(1,0) == x) && (gameBoard.getField(1,1) == x) && (gameBoard.getField(1,2) == x))||
                ((gameBoard.getField(2,0) == x) && (gameBoard.getField(2,1) == x) && (gameBoard.getField(2,2) == x))||
                ((gameBoard.getField(0,0) == x) && (gameBoard.getField(1,0) == x) && (gameBoard.getField(2,0) == x))||
                ((gameBoard.getField(0,1) == x) && (gameBoard.getField(1,1) == x) && (gameBoard.getField(2,1) == x))||
                ((gameBoard.getField(0,2) == x) && (gameBoard.getField(1,2) == x) && (gameBoard.getField(2,2) == x))||
                ((gameBoard.getField(0,0) == x) && (gameBoard.getField(1,1) == x) && (gameBoard.getField(2,2) == x))||
                ((gameBoard.getField(2,0) == x) && (gameBoard.getField(1,1) == x) && (gameBoard.getField(0,2) == x))
        ){
            return true;
        }
        else {
            return false;
        }
    }
}
