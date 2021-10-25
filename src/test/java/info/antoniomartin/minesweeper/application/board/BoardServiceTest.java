package info.antoniomartin.minesweeper.application.board;

import info.antoniomartin.minesweeper.domain.Cell;
import info.antoniomartin.minesweeper.insfrastructure.cache.Cache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {
    private BoardService boardService;

    private Cache cache;
    @BeforeEach
    void beforeAll() {
        cache = new Cache();
        cache.addUser("tester", CreateTestBoard.getDemoBoard());
        boardService = new BoardService(cache);
    }

    @Test
    @DisplayName("Generate a new Board")
    void should_generate_board_when_create_new_board() {
        //given
        int rows = 20;
        int cols = 10;
        int numberOfMines = 30;

        //when
        BoardResponse board = boardService.create(rows, cols, numberOfMines);

        //then
        assertThat(board.getColNumber()).isEqualTo(cols);
        assertThat(board.getRowNumber()).isEqualTo(rows);

    }

    @Test
    void should_generate_board_when_create_new_board_with_wrong_data() {
        //given
        int rows = 0;
        int cols = 0;
        int numberOfMines = 0;

        //when
        BoardResponse board = boardService.create(rows, cols, numberOfMines);

        //then
        assertThat(board.getColNumber()).isEqualTo(cols);
        assertThat(board.getRowNumber()).isEqualTo(rows);
    }

//    @Test
//    @DisplayName("Open a Cell with Mine")
//    void should_open_a_cell_with_a_mine() {
//        //given The Board
//        //when
//        Cell[][] board = boardService.openCell(0, 0);
//
//        //then
//        assertThat(board).isNull();
//    }

//    @Test
//    @DisplayName("Open a Cell Opened")
//    void should_open_a_cell_with_was_opened() {
//        //given The Board
//        Cell cell = cache.getUserBoard("tester")[0][4];
//
//        //when
//        Cell[][] board = boardService.openCell(0, 4);
//
//        //then
//        assertThat(board[0][4]).isEqualTo(cell);
//    }

}
