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

    @GetMapping(value = "/")
    public ResponseEntity<Object> printGame(){
        return ResponseEntity.status(HttpStatus.OK).body(gameBoardService.getGame());
    }

    @PostMapping(value = "/{x}&{y}")
    public ResponseEntity<Object> playerPlay(@PathVariable int x, @PathVariable int y){
        if (gameBoardService.getField(x,y) == '-'){
            gameBoardService.setField(x, y);
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
