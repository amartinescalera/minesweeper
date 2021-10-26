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

    private static final Random randomTrueFalse = new Random();
    private final Cache cache;

    @Override
    public BoardResponse create(String userId, int row, int col, int numberOfMines) {
        return getBoardResponse(createBoard(userId, row, col, numberOfMines));
    }

    @Override
    public BoardResponse getActiveBoard(String userId) {
        if (cache.hasBoard(userId)) {
            return getBoardResponse(cache.getUserBoard(userId));
        } else {
            return BoardResponse.builder().build();
        }
    }

    public Cell[][] openCell(final String userId, final int row, final int col) {
        Cell cell = getCell(userId, row, col);
        if (Objects.nonNull(cell) && cell.getType().equals(CellType.CELL_CLOSE)) {
            updateBoard(userId, openCell(cell), row, col);
        }
        return cache.getUserBoard(userId);
    }

    private Cell[][] createBoard(final String userId,
                                 final int row,
                                 final int col,
                                 final int numberOfMines) {
        if (cache.hasBoard(userId)) {
            return cache.getUserBoard(userId);
        } else {
            return initialize(row, col, numberOfMines);
        }
    }

    private void updateBoard(final String userId,
                             final Cell cellOpened,
                             final int row,
                             final int col) {
        final Cell[][] board = cache.getUserBoard(userId);
        board[row][col] = cellOpened;
        cache.updateBoard(userId, board);
    }

    private Cell openCell(final Cell cell) {
        if (cell.isMine()) {
            return Cell.builder()
                .mine(cell.isMine())
                .minesInMyNeighbour(cell.getMinesInMyNeighbour())
                .type(CellType.CELL_MINE)
                .build();
        } else {
            return Cell.builder()
                .mine(cell.isMine())
                .minesInMyNeighbour(cell.getMinesInMyNeighbour())
                .type(CellType.CELL_OPEN)
                .build();
        }
    }

    private Cell getCell(final String userId, final int row, final int col) {
        Cell[][] board = cache.getUserBoard(userId);
        if (row < board.length && col < board[0].length) {
            return board[row][col];
        }
        return null;
    }

    private Cell[][] initialize(final int row, final int col, final int numberOfMines) {
        int numberOfMinesUpdated = numberOfMines;
        final Cell[][] boardGameCell = new Cell[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (randomTrueFalse.nextBoolean() && numberOfMinesUpdated > 0) {
                    numberOfMinesUpdated--;
                    boardGameCell[i][j] = Cell.builder().mine(true).type(CellType.CELL_CLOSE).build();
                } else {
                    boardGameCell[i][j] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
                }

            }
        }
        return boardGameCell;
    }

    private BoardResponse getBoardResponse(final Cell[][] cells) {
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
