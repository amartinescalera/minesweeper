package info.antoniomartin.minesweeper.application.board;

import info.antoniomartin.minesweeper.domain.Cell;
import info.antoniomartin.minesweeper.domain.CellType;
import info.antoniomartin.minesweeper.insfrastructure.cache.Cache;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

@AllArgsConstructor
@Service
public class BoardService implements CreateBoard, GetActiveBoard {

    private static final String USER_ID = "userId";
    private static final Random randomTrueFalse = new Random();

    private final Cache cache;

    @Override
    public BoardResponse create(int row, int col, int numberOfMines) {
        return getBoardResponse(createBoard(row, col, numberOfMines));
    }

    @Override
    public BoardResponse getActiveBoard() {
        if (cache.hasBoard(USER_ID)) {
            return getBoardResponse(cache.getUserBoard(USER_ID));
        } else {
            return BoardResponse.builder().build();
        }
    }

    private Cell[][] createBoard(int row, int col, int numberOfMines) {
        if (cache.hasBoard(USER_ID)) {
            return cache.getUserBoard(USER_ID);
        } else {
            return initialize(row, col, numberOfMines);
        }
    }

    public Cell[][] openCell(final int row, final int col) {
        Cell cell = getCell(row, col);
        if (Objects.nonNull(cell) && cell.getType().equals(CellType.CELL_CLOSE)) {
            if (cell.isMine()) {
                Cell.builder()
                    .mine(cell.isMine())
                    .minesInMyNeighbour(cell.getMinesInMyNeighbour())
                    .type(CellType.CELL_MINE)
                    .build();
            } else {
                Cell.builder()
                    .mine(cell.isMine())
                    .minesInMyNeighbour(cell.getMinesInMyNeighbour())
                    .type(CellType.CELL_OPEN)
                    .build();
            }
        }
        return cache.getUserBoard(USER_ID);
    }

    private Cell getCell(final int row, final int col) {
        Cell[][] board = cache.getUserBoard(USER_ID);
        if (row < board.length && col < board[0].length) {
            return board[row][col];
        }
        return null;
    }

    private Cell[][] initialize(int row, int col, int numberOfMines) {
        Cell[][] boardGameCell = new Cell[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (randomTrueFalse.nextBoolean() && numberOfMines > 0) {
                    numberOfMines--;
                    boardGameCell[i][j] = Cell.builder().mine(true).type(CellType.CELL_CLOSE).build();
                } else {
                    boardGameCell[i][j] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
                }

            }
        }
        return boardGameCell;
    }

    private BoardResponse getBoardResponse(Cell[][] cells) {
        if (cells.length <= 0 || cells[0].length <= 0) {
            return BoardResponse.builder().build();
        } else {
            return BoardResponse.builder()
                .rowNumber(cells.length)
                .colNumber(cells[0].length)
                .myBoard(cells)
                .build();
        }

    }
}
