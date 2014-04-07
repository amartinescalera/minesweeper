package info.antoniomeh.minesweeper.model;

/**
 * Nemedus Org.
 * User: amartin
 * Date: 13/09/13
 */
public class Cell {

    private Boolean mine;
    private CellEnum status;

    private Integer numNeighbour;
    private Integer rowPosition;
    private Integer columnPosition;
    private Integer minesInMyNeighbour;

    public Cell() {
        mine = Boolean.FALSE;
        status = CellEnum.CELL_CLOSE;
    }

    public Cell(Boolean _mine) {
        mine = _mine;
    }

    public Cell(Integer _numNeighbour) {
        numNeighbour = _numNeighbour;
    }


    public Cell(Boolean _mine, CellEnum _status) {
        mine = _mine;
        status = _status;
    }

    public Boolean isMine() {
        return mine;
    }

    public void setMine (Boolean BOMBA) {
        this.mine = BOMBA;
    }

    public CellEnum getStatus() {
        return this.status;
    }

    public Integer getNumNeighbour() {
        return this.numNeighbour;
    }

    public Integer getColumnPosition() {
        return columnPosition;
    }

    public void setColumnPosition(Integer yPosition) {
        this.columnPosition = yPosition;
    }

    public Integer getRowPosition() {
        return rowPosition;
    }

    public void setRowPosition(Integer xPosition) {
        this.rowPosition = xPosition;
    }

    public void setMinesInMyNeighbour(Integer minesInMyNeighbour) {
        this.minesInMyNeighbour = minesInMyNeighbour;
    }

    public Integer getMinesInMyNeighbour() {
        return minesInMyNeighbour;
    }

    public void setStatus(CellEnum status) {
        this.status = status;
    }

    public boolean isOpen() {
        boolean res = false;
        if (this.getStatus().equals(CellEnum.CELL_OPEN)) {
            res = true;
        }
        return res;
    }

    public boolean isFlag() {
        boolean res = false;
        if (this.getStatus().equals(CellEnum.CELL_FLAG)) {
            res = true;
        }
        return res;
    }
}
