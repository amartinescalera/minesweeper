package info.antoniomartin.minesweeper.insfrastructure.rest.board.getboard;

import info.antoniomartin.minesweeper.application.board.BoardResponse;
import info.antoniomartin.minesweeper.application.board.BoardService;
import info.antoniomartin.minesweeper.insfrastructure.cache.Cache;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RestController
public class BoardController {

    private final Cache myBoard;
    private final BoardService boardService;

    @GetMapping("/board/{rows}/{cells}/{numberOfMines}")
    public ResponseEntity<BoardResponse> getBoard(@PathVariable int rows, @PathVariable int cells, @PathVariable int numberOfMines) {
        if (myBoard.getTheBoard() == null) {
            BoardResponse response = boardService.createBoard(rows, cells, numberOfMines);
            myBoard.setTheBoard(response);
        }

        return ResponseEntity.ok(myBoard.getTheBoard());
    }

    @GetMapping("/board")
    public ResponseEntity<BoardResponse> getBoard() {
        return ResponseEntity.ok(getActiveBoard());
    }

    private BoardResponse getActiveBoard() {
        if (myBoard.getTheBoard() != null) {
            return myBoard.getTheBoard();
        } else {
            return BoardResponse.builder().build();
        }
    }
}
