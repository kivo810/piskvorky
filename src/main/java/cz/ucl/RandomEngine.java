package cz.ucl;

import org.springframework.beans.factory.annotation.Autowired;

public class RandomEngine implements ITIcTacToeEngine {
    @Autowired
    GameBoard gameBoard;

    @Override
    public void cpuPlay() {

    }
}
