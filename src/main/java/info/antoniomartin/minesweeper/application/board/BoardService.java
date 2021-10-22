package info.antoniomartin.minesweeper.application.board;

import info.antoniomartin.minesweeper.domain.Board;
import info.antoniomartin.minesweeper.domain.Cell;
import info.antoniomartin.minesweeper.domain.CellType;
import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class BoardService {

    public Board createBoard(int row, int col, int numberOfMines) {
        return Board.builder()
            .rowNumber(row)
            .colNumber(col)
            .numberOfMines(numberOfMines)
            .myBoard(initialize(row, col, numberOfMines))
            .build();
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
