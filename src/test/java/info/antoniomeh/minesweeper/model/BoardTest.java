package info.antoniomeh.minesweeper.model;

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Nemedus Org.
 * User: amartin
 * Date: 16/09/13
 */
public class BoardTest {

    @Test
    public void i_am_assign_the_fields_with_corrects_values_without() {
        Board board = new Board();
        assertEquals(board.getRowNumber(), Integer.valueOf(30));
        assertEquals(board.getColNumber(), Integer.valueOf(30));
        assertEquals(board.getNumberOfMines(), Integer.valueOf(90));
        assertEquals(board.getNumberOfCells(), Integer.valueOf(900));
        assertTrue(board.isValid());
    }

    @Test
    public void i_am_assign_the_fields_with_corrects_values() {
        Board board = new Board(5,2);
        board.setNumberOfMines(3);
        assertEquals(board.getRowNumber(), Integer.valueOf(5));
        assertEquals(board.getColNumber(), Integer.valueOf(2));
        assertEquals(board.getNumberOfCells(), Integer.valueOf(10));
        assertTrue(board.isValid());
    }

    @Test
    public void i_am_assign_the_fields_with_corrects_values_with_three_fields() {
        Board board = new Board(5,2,4);
        assertEquals(board.getRowNumber(), Integer.valueOf(5));
        assertEquals(board.getColNumber(), Integer.valueOf(2));
        assertEquals(board.getNumberOfCells(), Integer.valueOf(10));
        assertEquals(board.getNumberOfMines(), Integer.valueOf(4));
        assertTrue(board.isValid());
    }

    @Test
    public void i_am_a_valid_board() {
        Board board = new Board(5,2);
        board.setNumberOfMines(2);
        assertTrue(board.isValid());
    }

    @Test
    public void i_am_a_ten_percente_of_mines() {
        Board board = new Board (10,10,25);
        assertTrue(board.isValid());
    }

    @Test
    public void i_am_an_invalid_board() {
        Board board = new Board (1,1,1);
        assertFalse(board.isValid());
    }

    @Test
    public void where_have_I_neighbour() {
        Board board = new Board();
        Cell mockCell_1 = mock(Cell.class);
        when (mockCell_1.getRowPosition()).thenReturn(15);
        when (mockCell_1.getColumnPosition()).thenReturn(15);

        Cell mockCell_2 = mock(Cell.class);
        Cell mockCell_3 = mock(Cell.class);
        Cell mockCell_4 = mock(Cell.class);

        //Insert the cells in a specific position
        board.setCell(mockCell_1, 15, 15);
        board.setCell(mockCell_2, 16, 14);
        board.setCell(mockCell_3, 16, 15);
        board.setCell(mockCell_4, 16, 16);

        List<Cell> myNeighbour = board.getNeighbour(mockCell_1);
        assertEquals(Integer.valueOf(myNeighbour.size()), Integer.valueOf(3));
    }

    @Test
    public void which_neighbour_should_I_process_if_I_am_a_corner() {
        Board board = new Board();

        Cell mockCell_1 = mock(Cell.class);
        when (mockCell_1.getRowPosition()).thenReturn(15);
        when (mockCell_1.getColumnPosition()).thenReturn(15);

        Cell mockCell_2 = mock(Cell.class);
        when (mockCell_2.getStatus()).thenReturn(CellEnum.CELL_CLOSE);
        Cell mockCell_3 = mock(Cell.class);
        when (mockCell_3.getStatus()).thenReturn(CellEnum.CELL_CLOSE);
        Cell mockCell_4 = mock(Cell.class);
        when (mockCell_4.getStatus()).thenReturn(CellEnum.CELL_OPEN);

        //Insert the cells in a specific position
        board.setCell(mockCell_1, 15, 15);
        board.setCell(mockCell_2, 16, 14);
        board.setCell(mockCell_3, 16, 15);
        board.setCell(mockCell_4, 16, 16);

        List<Cell> myNeighbour = board.nighbourToProcess(mockCell_1);
        assertEquals(Integer.valueOf(myNeighbour.size()), Integer.valueOf(2));
    }

    @Test
    public void play_a_fail_game() {
        Board board = new Board();

        Cell mockCell_01 = mock(Cell.class);
        when (mockCell_01.getStatus()).thenReturn(CellEnum.CELL_CLOSE);
        when (mockCell_01.getRowPosition()).thenReturn(0);
        when (mockCell_01.getColumnPosition()).thenReturn(0);
        when (mockCell_01.isMine()).thenReturn(true);

        assertFalse("WE DON'T CONTINUE IN THE GAME", board.playGame(mockCell_01));

    }

    @Test
    public void play_a_basic_game() {
        Board board = new Board();
        board.setRowNumber(1);
        board.setColNumber(10);
        board.setNumberOfMines(1);

        Cell mockCell_01 = mock(Cell.class);
        when (mockCell_01.getStatus()).thenReturn(CellEnum.CELL_CLOSE);
        when (mockCell_01.getRowPosition()).thenReturn(0);
        when (mockCell_01.getColumnPosition()).thenReturn(0);
        when (mockCell_01.isMine()).thenReturn(false);

        Cell mockCell_02 = mock(Cell.class);
        when (mockCell_02.getStatus()).thenReturn(CellEnum.CELL_CLOSE);
        when (mockCell_02.getRowPosition()).thenReturn(0);
        when (mockCell_02.getColumnPosition()).thenReturn(1);
        when (mockCell_02.isMine()).thenReturn(false);

        Cell mockCell_03 = mock(Cell.class);
        when (mockCell_03.getStatus()).thenReturn(CellEnum.CELL_CLOSE);
        when (mockCell_03.getRowPosition()).thenReturn(0);
        when (mockCell_03.getColumnPosition()).thenReturn(2);
        when (mockCell_03.isMine()).thenReturn(false);

        Cell mockCell_04 = mock(Cell.class);
        when (mockCell_04.getStatus()).thenReturn(CellEnum.CELL_CLOSE);
        when (mockCell_04.getRowPosition()).thenReturn(0);
        when (mockCell_04.getColumnPosition()).thenReturn(3);
        when (mockCell_04.isMine()).thenReturn(false);

        Cell mockCell_05 = mock(Cell.class);
        when (mockCell_05.getStatus()).thenReturn(CellEnum.CELL_CLOSE);
        when (mockCell_05.getRowPosition()).thenReturn(0);
        when (mockCell_05.getColumnPosition()).thenReturn(4);
        when (mockCell_05.isMine()).thenReturn(false);

        Cell mockCell_06 = mock(Cell.class);
        when (mockCell_06.getStatus()).thenReturn(CellEnum.CELL_CLOSE);
        when (mockCell_06.getRowPosition()).thenReturn(0);
        when (mockCell_06.getColumnPosition()).thenReturn(5);
        when (mockCell_06.isMine()).thenReturn(false);

        Cell mockCell_07 = mock(Cell.class);
        when (mockCell_07.getStatus()).thenReturn(CellEnum.CELL_CLOSE);
        when (mockCell_07.getRowPosition()).thenReturn(0);
        when (mockCell_07.getColumnPosition()).thenReturn(6);
        when (mockCell_07.isMine()).thenReturn(false);

        Cell mockCell_08 = mock(Cell.class);
        when (mockCell_08.getStatus()).thenReturn(CellEnum.CELL_CLOSE);
        when (mockCell_08.getRowPosition()).thenReturn(0);
        when (mockCell_08.getColumnPosition()).thenReturn(7);
        when (mockCell_08.isMine()).thenReturn(false);

        Cell mockCell_09 = mock(Cell.class);
        when (mockCell_09.getStatus()).thenReturn(CellEnum.CELL_CLOSE);
        when (mockCell_09.getRowPosition()).thenReturn(0);
        when (mockCell_09.getColumnPosition()).thenReturn(8);
        when (mockCell_09.isMine()).thenReturn(true);

        Cell mockCell_10 = mock(Cell.class);
        when (mockCell_10.getStatus()).thenReturn(CellEnum.CELL_CLOSE);
        when (mockCell_10.getRowPosition()).thenReturn(0);
        when (mockCell_10.getColumnPosition()).thenReturn(9);
        when (mockCell_10.isMine()).thenReturn(false);

        board.setCell(mockCell_01,0,0);
        board.setCell(mockCell_02,0,1);
        board.setCell(mockCell_03,0,2);
        board.setCell(mockCell_04,0,3);
        board.setCell(mockCell_05,0,4);
        board.setCell(mockCell_06,0,5);
        board.setCell(mockCell_07,0,6);
        board.setCell(mockCell_08,0,7);
        board.setCell(mockCell_09,0,8);
        board.setCell(mockCell_10,0,9);

        assertTrue("WE CHECK THE CONFIGURATION", board.isValid());
        Cell cell = board.getCell(0,5);
        board.openCell(cell);
        when (mockCell_06.getStatus()).thenReturn(CellEnum.CELL_OPEN);

        assertFalse("IT'S NOT A BOMB, LET'S GO TO PROCESS ANOTHER CELLS",cell.isMine());
        assertEquals("IT'S OPEN", cell.getStatus(),CellEnum.CELL_OPEN);

        //Get de Neighbour to process
        List<Cell> cells = board.processNeighbour(mockCell_06);
        assertEquals("INCLUDE TWO CELLS: 5 and 7", Integer.valueOf(cells.size()), Integer.valueOf(2));

        when (mockCell_05.getStatus()).thenReturn(CellEnum.CELL_OPEN);
        when (mockCell_07.getStatus()).thenReturn(CellEnum.CELL_OPEN);

        //Get the mock_07
        Cell cell2 = cells.get(0);
        List<Cell> cells_secondIteration = board.processNeighbour(cell2);
        assertEquals("INCLUDE ONE CELL: 8",Integer.valueOf(cells_secondIteration.size()), Integer.valueOf(1));

        when (mockCell_08.getStatus()).thenReturn(CellEnum.CELL_OPEN);

        //Get the mock_08
        Cell cell3 = cells_secondIteration.get(0);
        List<Cell> cells_thirdIteration = board.processNeighbour(cell3);
        assertNull("INCLUDE NONE CELL ", cells_thirdIteration);

        //Get the mock_05
        Cell cell4 = cells.get(1);
        List<Cell> cells_fourthIteration = board.processNeighbour(cell4);
        assertEquals("INCLUDE ONE CELL: 4",Integer.valueOf(cells_fourthIteration.size()), Integer.valueOf(1));

        when (mockCell_04.getStatus()).thenReturn(CellEnum.CELL_OPEN);

        //Get the mock_04
        Cell cell5 = cells_fourthIteration.get(0);
        List<Cell> cells_fifthIteration = board.processNeighbour(cell5);
        assertEquals("INCLUDE ONE CELL: 3",Integer.valueOf(cells_fifthIteration.size()), Integer.valueOf(1));

        when (mockCell_03.getStatus()).thenReturn(CellEnum.CELL_OPEN);

        //Get the mock_03
        Cell cell6 = cells_fifthIteration.get(0);
        List<Cell> cells_sixthIteration = board.processNeighbour(cell6);
        assertEquals("INCLUDE ONE CELL: 2",Integer.valueOf(cells_sixthIteration.size()), Integer.valueOf(1));

        when (mockCell_02.getStatus()).thenReturn(CellEnum.CELL_OPEN);

        //Get the mock_02
        Cell cell7 = cells_sixthIteration.get(0);
        List<Cell> cells_seventhIteration = board.processNeighbour(cell7);
        assertEquals("INCLUDE ONE CELL: 1",Integer.valueOf(cells_seventhIteration.size()), Integer.valueOf(1));

        when (mockCell_01.getStatus()).thenReturn(CellEnum.CELL_OPEN);

        //Get the mock_01
        Cell cell8 = cells_seventhIteration.get(0);
        List<Cell> cells_eigthIteration = board.processNeighbour(cell8);
        assertNull("INCLUDE NO CELL",cells_eigthIteration);

        Cell cell9 = board.getCell(0,9);
        board.openCell(cell9);
        when (mockCell_10.getStatus()).thenReturn(CellEnum.CELL_OPEN);

        List<Cell> cells_ninethIteration = board.processNeighbour(cell9);
        assertNull("INCLUDE NO CELL, THE GAME IS FINISHED",cells_ninethIteration);
    }
}
