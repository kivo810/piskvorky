package cz.ucl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StateChecker implements IStateChecker {

    @Autowired
    GameBoardService gameBoardService;

    @Override
    public boolean checkWinner(GameBoard gameBoard, char x) {
        if (((gameBoard.getField(0,0) == x) && (gameBoard.getField(0,1) == x) && (gameBoard.getField(0,2) == x))|| //TOP ROW
                ((gameBoard.getField(1,0) == x) && (gameBoard.getField(1,1) == x) && (gameBoard.getField(1,2) == x))|| //MID ROW
                ((gameBoard.getField(2,0) == x) && (gameBoard.getField(2,1) == x) && (gameBoard.getField(2,2) == x))|| // BOT ROW
                ((gameBoard.getField(0,0) == x) && (gameBoard.getField(1,0) == x) && (gameBoard.getField(2,0) == x))|| // LEFT COL
                ((gameBoard.getField(0,1) == x) && (gameBoard.getField(1,1) == x) && (gameBoard.getField(2,1) == x))|| //MID COL
                ((gameBoard.getField(0,2) == x) && (gameBoard.getField(1,2) == x) && (gameBoard.getField(2,2) == x))|| // RIGHT COL
                ((gameBoard.getField(0,0) == x) && (gameBoard.getField(1,1) == x) && (gameBoard.getField(2,2) == x))|| //CROSS 1
                ((gameBoard.getField(2,0) == x) && (gameBoard.getField(1,1) == x) && (gameBoard.getField(0,2) == x)) //CROSS 2
        ){
            return true;
        }
        else {
            return false;
        }
    }
}
