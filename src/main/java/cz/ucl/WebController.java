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
    public ResponseEntity<Object> playerPlay(@PathVariable int x){
        int xy[] = randomEngine.parsingToGB(x);
        if(gameBoardService.getField(xy[0],xy[1]) == '-'){
            gameBoardService.setField(xy[0],xy[1],'X');
            return ResponseEntity.status(HttpStatus.OK).body(gameBoardService.getGame());
        }
        else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(gameBoardService.getGame());
        }

    }

    @DeleteMapping(value = "/")
    public ResponseEntity<Object> refreshGame(){
        gameBoardService.refreshGame();
        return ResponseEntity.status(HttpStatus.OK).body(gameBoardService.getGame());
    }

}
