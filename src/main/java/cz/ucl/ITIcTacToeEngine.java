package cz.ucl;

import org.springframework.http.ResponseEntity;

public interface ITIcTacToeEngine {
    ResponseEntity<Object> playerMove(int x);
    ResponseEntity<Object> cpuMove();
}
