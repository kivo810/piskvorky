package cz.ucl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired
    GameBoardService gameBoardService;

    @Autowired
    StateChecker stateChecker;

    @Autowired
    RandomEngine randomEngine;

    @GetMapping(value = "/")
    public ResponseEntity<Object> printGame(){
        return ResponseEntity.status(HttpStatus.OK).body(gameBoardService.getGame());
    }

    @PostMapping(value = "/{x}")
    public ResponseEntity<Object> playGame(@PathVariable int x){
        if (x < 1 || x > 9) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("You are out of bounds!");
        }
        ResponseEntity<Object> playerResult = randomEngine.playerMove(x);
        if (playerResult.getStatusCode().equals(HttpStatus.CONFLICT)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This field is not empty!");
        }
        if (stateChecker.checkWinner(gameBoardService.gameBoard, 'X')){
            gameBoardService.refreshGame();
            return ResponseEntity.status(HttpStatus.OK).body("Player WINS!!!");
        }
        if (gameBoardService.getMoves() == 9){
            gameBoardService.refreshGame();
            return ResponseEntity.status(HttpStatus.OK).body("ITS A DRAW");
        }
        ResponseEntity<Object> cpuResult = randomEngine.cpuMove();
        if (stateChecker.checkWinner(gameBoardService.gameBoard,'O')){
            gameBoardService.refreshGame();
            return ResponseEntity.status(HttpStatus.OK).body("CPU WINS!!");
        }
        return cpuResult;
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<Object> refreshGame(){
        gameBoardService.refreshGame();
        return ResponseEntity.status(HttpStatus.OK).body(gameBoardService.getGame());
    }

}
