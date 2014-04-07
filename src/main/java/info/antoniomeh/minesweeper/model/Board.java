package info.antoniomeh.minesweeper.model;

import java.util.ArrayList;
import java.util.List;

/**
 * OdigeO
 * User: amartin
 * Date: 12/09/13
 */
public class Board {

    private static final int NUMBER_ROWS = 30;
    private static final int NUMBER_COLUM = 30;
    private static final int NUMBER_MINES = 90;

    private Integer rowNumber;
    private Integer colNumber;
    private Integer numberOfMines;
    private Integer numberOfCells;
    private Cell[][] myBoard = null;

    public Board() {
        this.rowNumber = NUMBER_ROWS;
        this.numberOfMines = NUMBER_MINES;
        this.colNumber = NUMBER_COLUM;
        this.numberOfCells = calculateNumberOfCells();
    }

    public Board(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.numberOfMines = 0;
        this.numberOfCells = calculateNumberOfCells();
    }

    public Board(int rowNumber, int colNumber, int numberOfMines) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.numberOfMines = numberOfMines;
        this.numberOfCells = calculateNumberOfCells();
    }

    private int calculateNumberOfCells() {
        int cellNumber = 0;
        if (this.getRowNumber() != null && this.getColNumber() != null) {
            cellNumber = this.rowNumber * this.colNumber;
        }
        return cellNumber;
    }

    public Boolean isValid() {
        return haveValidMines() && haveValidNumber();
    }

    public Boolean haveValidNumber() {
        Boolean isValid = false;
        if (this.getNumberOfCells() != 0) {
            if (this.getNumberOfCells() >= 10) {
                isValid = true;
            }
        }
        return isValid;
    }

    public Boolean haveValidMines() {
        Boolean isValid = false;
        if (this.getNumberOfCells() != 0) {
            if (((this.getNumberOfCells() * 0.1) <= this.getNumberOfMines()) &&
                    ((this.getNumberOfCells() * 0.5) >= this.getNumberOfMines())) {
                isValid = true;
            }
        }
        return isValid;
    }

    public void setCell(Cell cell, int rowPosition, int cellPosition) {
        initializeBoard();
        myBoard[rowPosition] [cellPosition] = cell;
    }

    public Cell getCell(int row, int column) {
        Cell cell = null;
        if (myBoard != null) {
            if ((row >= 0 && row < this.getRowNumber()) && (column >= 0 && column < this.getColNumber())) {
                cell = myBoard[row][column];
            }
        }

        return cell;
    }

    private void initializeBoard() {
        if (myBoard == null) {
            myBoard = new Cell[this.getRowNumber()][this.getColNumber()];
            for (int i=0;i<this.getRowNumber();i++) {
                for (int j=0; j<this.getColNumber(); j++) {
                    myBoard[i][j] = null;
                }
            }
        }
    }

    public List<Cell> getNeighbour(Cell cell) {
        List<Cell> myNeighbourhoud = new ArrayList<Cell>();
        Cell cellAux;
        // - 1
        cellAux = this.getCell(cell.getRowPosition() - 1, cell.getColumnPosition());
        if (cellAux != null) {
            myNeighbourhoud.add(cellAux);
        }

        // - 2
        cellAux = this.getCell(cell.getRowPosition() - 1, cell.getColumnPosition() + 1);
        if (cellAux != null) {
            myNeighbourhoud.add(cellAux);
        }

        // - 3
        cellAux = this.getCell(cell.getRowPosition(), cell.getColumnPosition() + 1);
        if (cellAux != null) {
            myNeighbourhoud.add(cellAux);
        }

        // - 4
        cellAux = this.getCell(cell.getRowPosition() + 1, cell.getColumnPosition() + 1);
        if (cellAux != null) {
            myNeighbourhoud.add(cellAux);
        }

        // - 5
        cellAux = this.getCell(cell.getRowPosition() + 1, cell.getColumnPosition());
        if (cellAux != null) {
            myNeighbourhoud.add(cellAux);
        }

        // - 6
        cellAux = this.getCell(cell.getRowPosition() + 1, cell.getColumnPosition() - 1);
        if (cellAux != null) {
            myNeighbourhoud.add(cellAux);
        }

        // - 7
        cellAux = this.getCell(cell.getRowPosition(), cell.getColumnPosition() - 1);
        if (cellAux != null) {
            myNeighbourhoud.add(cellAux);
        }

        // - 8
        cellAux = this.getCell(cell.getRowPosition() - 1, cell.getColumnPosition() - 1);
        if (cellAux != null) {
            myNeighbourhoud.add(cellAux);
        }

        // - 9
        cellAux = this.getCell(cell.getRowPosition() - 1, cell.getColumnPosition());
        if (cellAux != null) {
            myNeighbourhoud.add(cellAux);
        }

        return myNeighbourhoud;
    }

    public List<Cell> nighbourToProcess(Cell mockCell_1) {
        List<Cell> cellToProcess = null;
        List<Cell> cellNeighbour = this.getNeighbour(mockCell_1);

        for (Cell cellToCheck: cellNeighbour) {
            if (cellToProcess == null) {
                cellToProcess = new ArrayList<Cell>();
            }

            if (cellToCheck.getStatus().equals(CellEnum.CELL_CLOSE)) {
                cellToProcess.add(cellToCheck);
            }
        }
        return cellToProcess;
    }

    public boolean playGame(Cell cell) {
        boolean res = false;
        if (!cell.isMine()) {
            List<Cell> cells = processNeighbour(cell);
            if (cells != null) {
                processAllNeighbour(cells);
            }
        } else {
            openAllCells();
        }
        return res;
    }

    private void openAllCells() {
        myBoard = new Cell[this.getRowNumber()][this.getColNumber()];
        for (int i=0;i<this.getRowNumber();i++) {
            for (int j=0; j<this.getColNumber(); j++) {
                Cell cell = myBoard[i][j];
                if (cell != null && !cell.isOpen()) {
                    if (cell.isMine()) {
                        cell.setStatus(CellEnum.CELL_MINE);
                    } else {
                        cell.setStatus(CellEnum.CELL_OPEN);
                    }
                }
            }
        }
    }

    private void processAllNeighbour(List<Cell> cells) {
        for (Cell cell: cells) {
            List<Cell> cellsContinue = processNeighbour(cell);
            if (cellsContinue != null) {
                processAllNeighbour(cellsContinue);
            }
        }
    }

    public CellEnum openCell(Cell cell) {
        CellEnum status = null;
        if (cell !=null && !cell.isOpen() && !cell.isFlag()) {
            if (cell.isMine()) {
                cell.setStatus(CellEnum.CELL_EXPLOSION);
            } else {
                cell.setStatus(CellEnum.CELL_OPEN);
            }
            status = cell.getStatus();
        }
        return status;
    }

    /**
     * We receive  a cell and process all the neighbour if the neighbour aren't opened and it isn't a mine
     * @param cellOpened this mine was processed, we process the neighbour
     * @return continueProcessing it include a list of cell to process again;
     */
    public List<Cell> processNeighbour(Cell cellOpened) {
        List<Cell> continueProcessing = null;
        List<Cell> cellToProcess = this.nighbourToProcess(cellOpened);

        for (Cell cell:cellToProcess) {
            if (cell.isMine()) {
                if (cellOpened.getMinesInMyNeighbour() == null) {
                    cellOpened.setMinesInMyNeighbour(1);
                } else {
                    cellOpened.setMinesInMyNeighbour(cellOpened.getMinesInMyNeighbour() + 1);
                }
            } else if (!cell.isFlag() && !cell.isOpen()) {
                cell.setStatus(CellEnum.CELL_OPEN);
                if (continueProcessing == null) {
                    continueProcessing = new ArrayList<Cell>();
                }
                continueProcessing.add(cell);
            }
        }
        return continueProcessing;

    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
        this.numberOfCells = calculateNumberOfCells();
    }


    public Integer getColNumber() {
        return colNumber;
    }

    public void setColNumber(Integer colNumber) {
        this.colNumber = colNumber;
        this.numberOfCells = calculateNumberOfCells();
    }

    public Integer getNumberOfMines() {
        return numberOfMines;
    }

    public void setNumberOfMines(Integer numberOfMines) {
        this.numberOfMines = numberOfMines;
    }

    public Integer getNumberOfCells() {
        return numberOfCells;
    }
}