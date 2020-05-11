package cz.ucl;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class GameBoard {
    private char board [][];

    @PostConstruct
    public void initBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        printBoard();

    }

    public char[][] getBoard() {
        return board;
    }

    public char getField(int x, int y){
        return board[x][y];
    }

    public void printBoard(){
        for (int i = 0; i < 3; i++) {
            String doska = "|";
            for (int j = 0; j < 3; j++) {
                doska = doska + board[i][j] + "|";
            }
            System.out.println(doska);
        }
    }

}
