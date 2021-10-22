
import info.antoniomeh.minesweeper.model.Cell;
import info.antoniomeh.minesweeper.model.Board;
import info.antoniomeh.minesweeper.model.CellEnum;

/**
 * Nemedus Org.
 * User: amartin
 * Date: 13/09/13
 */
public class MinesWeeperService {

    public static void Initialize (Board board) {

        int contador = (board.getColNumber() * board.getRowNumber());

        for (int i=0;i< board.getRowNumber(); i++) {
            for (int j=0;j< board.getColNumber();j++) {
                Cell cell = board.getCell(i,j);
                if (cell == null) {
                    cell = new Cell();
                }
                cell.setStatus(CellEnum.CELL_CLOSE);
                if (isBomba(board, contador)) {
                    cell.setMine(Boolean.TRUE);

                } else {
                    cell.setMine(Boolean.FALSE);
                }
                board.setCell(cell, i,j);
                contador --;
            }
        }

    }

    private static boolean isBomba(Board board, int contador) {

        boolean returnValue = false;

        if (board.getNumberOfCells() < board.getNumberOfMines()) {
            if (contador > board.getNumberOfCells()) {
                if (Math.random() * 10 < 5) {
                    returnValue = true;
                }
            } else {
                returnValue = true;
            }
        }

        return returnValue;
    }
}

