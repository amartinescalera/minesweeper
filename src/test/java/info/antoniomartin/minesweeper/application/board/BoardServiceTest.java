package info.antoniomartin.minesweeper.application.board;

import info.antoniomartin.minesweeper.domain.Cell;
import info.antoniomartin.minesweeper.domain.CellType;
import info.antoniomartin.minesweeper.insfrastructure.cache.Cache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testing Board Services")
class BoardServiceTest {

    private static final String USER_ID = "tester";
    private BoardService boardService;
    private Cache cache;

    @BeforeEach
    void beforeAll() {
        cache = new Cache();
        cache.addUser(USER_ID, CreateTestBoard.getDemoBoard());
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
        BoardResponse board = boardService.create("Pepito", rows, cols, numberOfMines);

        //then
        assertThat(board.getColNumber()).isEqualTo(cols);
        assertThat(board.getRowNumber()).isEqualTo(rows);
    }

    @Test
    @DisplayName("Return active board when user have")
    void should_return_active_board_when_return_board_and_user_have() {
        //given
        Cell[][] boardInCache = cache.getUserBoard(USER_ID);

        //when
        BoardResponse boardResponse = boardService.getActiveBoard(USER_ID);

        //then
        assertThat(boardResponse.getMyBoard()).hasSameDimensionsAs(boardInCache);
        assertThat(boardResponse.getRowNumber()).isEqualTo(boardInCache.length);
        assertThat(boardResponse.getColNumber()).isEqualTo(boardInCache[0].length);
    }

    @Test
    @DisplayName("Return active board when user have and try to initialize")
    void should_return_active_cache_board_when_try_to_initialize() {
        //given
        Cell[][] boardInCache = cache.getUserBoard(USER_ID);
        final int fakeSize = 10;

        //when
        BoardResponse boardResponse = boardService.create(USER_ID, fakeSize,fakeSize,fakeSize);

        //then
        assertThat(boardResponse.getMyBoard()).hasSameDimensionsAs(boardInCache);
        assertThat(boardResponse.getRowNumber()).isEqualTo(boardInCache.length);
        assertThat(boardResponse.getRowNumber()).isNotEqualTo(fakeSize);
        assertThat(boardResponse.getColNumber()).isEqualTo(boardInCache[0].length);
    }

    @Test
    @DisplayName("Return active board when user does not have")
    void should_return_active_board_when_return_board_and_user_does_not_have() {
        //given
        //when
        BoardResponse boardResponse = boardService.getActiveBoard("pepito");

        //then
        assertThat(boardResponse.getMyBoard()).isNull();
        assertThat(boardResponse.getRowNumber()).isNull();
        assertThat(boardResponse.getColNumber()).isNull();
        assertThat(boardResponse.getNumberOfMines()).isNull();
        assertThat(boardResponse.getNumberOfCells()).isNull();
    }

    @Test
    @DisplayName("Generate a new Board with wrong Data")
    void should_generate_board_when_create_new_board_with_wrong_data() {
        //given
        int rows = 0;
        int cols = 0;
        int numberOfMines = 0;

        //when
        BoardResponse board = boardService.create("pepito", rows, cols, numberOfMines);

        //then
        assertThat(board.getColNumber()).isNull();
        assertThat(board.getRowNumber()).isNull();
    }

    @Test
    @DisplayName("Open a Cell with Mine")
    void should_open_a_cell_with_a_mine() {
        //given The Board
        //when
        Cell[][] board = boardService.openCell(USER_ID, 0, 0);

        //then
        assertThat(board[0][0].getType()).isEqualTo(CellType.CELL_MINE);
        assertThat(board[0][0].isMine()).isTrue();
    }

    @Test
    @DisplayName("Open a Cell Opened")
    void should_open_a_cell_with_was_opened() {
        //given The Board
        Cell cell = cache.getUserBoard(USER_ID)[0][4];

        //when
        Cell[][] board = boardService.openCell(USER_ID, 0, 4);

        //then
        assertThat(board[0][4]).isEqualTo(cell);
    }

    @Test
    @DisplayName("Open a Cell")
    void should_open_a_cell() {
        //given The Board
        Cell cell = cache.getUserBoard(USER_ID)[4][0];

        //when
        Cell[][] board = boardService.openCell(USER_ID, 4, 0);

        //then
        assertThat(cell.getType()).isEqualTo(CellType.CELL_CLOSE);
        assertThat(board[4][0].getType()).isEqualTo(CellType.CELL_OPEN);
    }

    @Test
    @DisplayName("Open a Cell that it does not exist")
    void should_open_a_cell_not_exist() {
        //given The Board
        //when
        Cell[][] board = boardService.openCell(USER_ID, 40, 0);

        //then
        assertThat(board[4][0].getType()).isEqualTo(CellType.CELL_CLOSE);
    }

}
