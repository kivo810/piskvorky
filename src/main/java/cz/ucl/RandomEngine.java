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

    @Override
    public ResponseEntity<Object> playerMove(int x) {
        int xy[] = parsingToGB(x);
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

        int xy[] = parsingToGB(n);
        if(gameBoardService.getField(xy[0],xy[1]) == '-'){
            gameBoardService.setField(xy[0],xy[1],'O');
        }
        else {
            cpuMove();
        }
        return ResponseEntity.status(HttpStatus.OK).body(gameBoardService.getGame());
    }
}
