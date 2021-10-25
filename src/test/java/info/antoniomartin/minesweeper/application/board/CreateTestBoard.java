package info.antoniomartin.minesweeper.application.board;

import info.antoniomartin.minesweeper.domain.Cell;
import info.antoniomartin.minesweeper.domain.CellType;

public class CreateTestBoard {

    /*
        * 2 1 B O
        2 * 1 B B
        1 1 1 1 1
        B B B 2 *
        B B B 1 *
     */

     public static Cell[][] getDemoBoard() {
         Cell[][] myBoard = new Cell[5][5];

         //row 1
         myBoard[0][0] = Cell.builder().mine(true).type(CellType.CELL_CLOSE).build();
         myBoard[0][1] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[0][2] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[0][3] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[0][4] = Cell.builder().mine(false).type(CellType.CELL_OPEN).build();

         //row 2
         myBoard[1][0] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[1][1] = Cell.builder().mine(true).type(CellType.CELL_CLOSE).build();
         myBoard[1][2] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[1][3] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[1][4] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();

         //row 3
         myBoard[2][0] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[2][1] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[2][2] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[2][3] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[2][4] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();

         //row 4
         myBoard[3][0] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[3][1] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[3][2] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[3][3] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[3][4] = Cell.builder().mine(true).type(CellType.CELL_CLOSE).build();

         //row 5
         myBoard[4][0] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[4][1] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[4][2] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[4][3] = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
         myBoard[4][4] = Cell.builder().mine(true).type(CellType.CELL_CLOSE).build();

         return myBoard;
     }
}
