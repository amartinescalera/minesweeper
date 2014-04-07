package info.antoniomeh.minesweeper.model;

import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Nemedus Org.
 * User: amartin
 * Date: 16/09/13
 */
public class CellTest {

    @Test
    public void I_have_a_mine() {

        Cell celda = new Cell();
        celda.setMine(true);
        assertTrue(celda.isMine());
    }

    @Test
    public void I_dont_have_a_mine() {
        Cell cell = new Cell(Boolean.FALSE);
        assertFalse(cell.isMine());
    }

    @Test
    public void I_am_open() {
        Cell cell = new Cell(Boolean.FALSE, CellEnum.CELL_OPEN);
        assertEquals(cell.getStatus(), CellEnum.CELL_OPEN);
        assertNotNull(cell.getStatus().getIcon());
    }

    @Test
    public void I_am_close() {
        Cell cell = new Cell(Boolean.FALSE, CellEnum.CELL_CLOSE);
        assertEquals(cell.getStatus(), CellEnum.CELL_CLOSE);
        assertNotNull(cell.getStatus().getIcon());
    }

    @Test
    public void someone_putme_a_flag() {
        Cell cell = new Cell(Boolean.FALSE, CellEnum.CELL_FLAG);
        assertEquals(cell.getStatus(), CellEnum.CELL_FLAG);
        assertNotNull(cell.getStatus().getIcon());
    }

    @Test
    public void I_am_exploted() {
        Cell cell = new Cell(Boolean.FALSE, CellEnum.CELL_EXPLOSION);
        assertEquals(cell.getStatus(), CellEnum.CELL_EXPLOSION);
        assertNotNull(cell.getStatus().getIcon());
    }

    @Test
    public void I_dont_have_neighbour() {
        Cell cell = new Cell();
        assertNull(cell.getNumNeighbour());

    }

    @Test
    public void I_have_three_neighbour() {
        Cell cell = new Cell(3);
        assertEquals(cell.getNumNeighbour(), Integer.valueOf(3));
    }

    @Test
    public void my_x_position_is_8(){
        Cell cell = new Cell();
        cell.setRowPosition(8);
        assertEquals(cell.getRowPosition(),Integer.valueOf(8));
    }

    @Test
    public void my_y_position_is_8(){
        Cell cell = new Cell();
        cell.setColumnPosition(8);
        assertEquals(cell.getColumnPosition(),Integer.valueOf(8));
    }

    @Test
    public void how_many_mines_have_in_my_neighbour(){
        Cell cell = new Cell();
        cell.setMinesInMyNeighbour(4);
        assertEquals(cell.getMinesInMyNeighbour(),Integer.valueOf(4));
    }

    @Test
    public void The_cell_is_open() {
        Cell cell = new Cell();
        cell.setStatus(CellEnum.CELL_OPEN);
        assertTrue(cell.isOpen());
    }

    @Test
    public void The_cell_is_a_flag() {
        Cell cell = new Cell();
        cell.setStatus (CellEnum.CELL_FLAG);
        assertTrue(cell.isFlag());
    }

    @Test
    public void Quit_a_flag_from_cell() {
        Cell cell = new Cell();
        cell.setStatus (CellEnum.CELL_FLAG);
        assertEquals(cell.getStatus(), CellEnum.CELL_FLAG);
        cell.setStatus(CellEnum.CELL_CLOSE);
        assertEquals(cell.getStatus(), CellEnum.CELL_CLOSE);
    }

}
