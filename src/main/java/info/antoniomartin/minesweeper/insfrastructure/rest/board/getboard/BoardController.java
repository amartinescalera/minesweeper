package info.antoniomartin.minesweeper.insfrastructure.rest.board.getboard;

import info.antoniomartin.minesweeper.application.board.BoardResponse;
import info.antoniomartin.minesweeper.application.board.CreateBoard;
import info.antoniomartin.minesweeper.application.board.GetActiveBoard;
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

    private final CreateBoard createBoard;
    private final GetActiveBoard activeBoard;
    private static final String USER_ID = "userId";

    @GetMapping("/board/{rows}/{cells}/{numberOfMines}")
    public ResponseEntity<BoardResponse> getBoard(@PathVariable int rows, @PathVariable int cells, @PathVariable int numberOfMines) {
        return ResponseEntity.ok(createBoard.create(rows, cells, numberOfMines));
    }

    @GetMapping("/board")
    public ResponseEntity<BoardResponse> getBoard() {
        return ResponseEntity.ok(activeBoard.getActiveBoard());
    }
}
