package info.antoniomartin.minesweeper.application.board;

import info.antoniomartin.minesweeper.domain.Board;
import info.antoniomartin.minesweeper.domain.Cell;
import info.antoniomartin.minesweeper.domain.CellType;
import info.antoniomartin.minesweeper.insfrastructure.cache.Cache;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

@AllArgsConstructor
@Service
public class BoardService {

    private final Cache myBoard;

    public BoardResponse createBoard(int row, int col, int numberOfMines) {
        Board newBoard = Board.builder()
            .rowNumber(row)
            .colNumber(col)
            .numberOfMines(numberOfMines)
            .myBoard(initialize(row, col, numberOfMines))
            .build();

        return BoardResponse.builder()
            .rowNumber(newBoard.getRowNumber())
            .colNumber(newBoard.getColNumber())
            .numberOfMines(numberOfMines)
            .numberOfCells(newBoard.numberOfCells())
            .myBoard(newBoard.getMyBoard())
            .build();
    }

    public BoardResponse openCell(final int row, final int col) {
        Cell cell = getCell(row, col);
        if (Objects.nonNull(cell) && cell.getType().equals(CellType.CELL_CLOSE)) {
            Cell.builder().build();
        } else {
            return null;
        }
    }

    private Cell getCell(final int row, final int col) {
        return myBoard.getTheBoard().getMyBoard()[row][col];
    }

    private Cell[][] initialize(int row, int col, int numberOfMines) {
        Random randomTrueFalse = new Random();
        Cell[][] boardGameCell = new Cell[row][col];
        for(int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (randomTrueFalse.nextBoolean() && numberOfMines > 0) {
                    numberOfMines --;
                    boardGameCell[i][j] = Cell.builder().mine(true).type(CellType.CELL_CLOSE).build();
                } else {
                    boardGameCell[i][j] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
                }

            }
        }
        return boardGameCell;
    }
}
