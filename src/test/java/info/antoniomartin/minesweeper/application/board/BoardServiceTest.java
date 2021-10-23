package info.antoniomartin.minesweeper.application.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {
    private BoardService boardService;

    @BeforeEach
    void beforeAll() {
        boardService = new BoardService();
    }

    @Test
    void should_generate_board_when_create_new_board() {
        //given
        int rows = 20;
        int cols = 10;
        int numberOfMines = 30;

        //when
        BoardResponse board = boardService.createBoard(rows, cols, numberOfMines);

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
        BoardResponse board = boardService.createBoard(rows, cols, numberOfMines);

        //then
        assertThat(board.getColNumber()).isEqualTo(cols);
        assertThat(board.getRowNumber()).isEqualTo(rows);

    }
}
