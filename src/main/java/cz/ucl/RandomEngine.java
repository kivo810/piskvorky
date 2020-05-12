package cz.ucl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomEngine implements ITIcTacToeEngine {
    @Autowired
    GameBoardService gameBoardService;


    @Override
    public ResponseEntity<Object> playerMove(int x) {
        int xy[] = gameBoardService.parsingToGB(x);
        if(gameBoardService.getField(xy[0],xy[1]) == '-'){
            gameBoardService.setField(xy[0],xy[1],'X');
            return ResponseEntity.status(HttpStatus.OK).body(gameBoardService.getGame());
        }
        else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(gameBoardService.getGame());
        }
    }

    @Override
    public ResponseEntity<Object> cpuMove() {
        Random random = new Random();

        int n = random.nextInt(9) + 1;

        int xy[] = gameBoardService.parsingToGB(n);
        if(gameBoardService.getField(xy[0],xy[1]) == '-'){
            gameBoardService.setField(xy[0],xy[1],'O');
        }
        else {
            cpuMove();
        }
        return ResponseEntity.status(HttpStatus.OK).body(gameBoardService.getGame());
    }
}
