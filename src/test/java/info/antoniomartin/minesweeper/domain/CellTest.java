package info.antoniomartin.minesweeper.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
class CellTest {

    @Test
    void I_have_a_mine() {
        Cell cell = Cell.builder().mine(true).build();
        assertTrue(cell.isMine());
    }

    @Test
    void I_dont_have_a_mine() {
        Cell cell = Cell.builder().mine(false).build();
        assertFalse(cell.isMine());
    }

    @Test
    void I_am_open() {
        Cell cell = Cell.builder().mine(false).type(CellType.CELL_OPEN).build();
        assertThat(cell.getType().name()).isEqualTo(CellType.CELL_OPEN.name());
    }


    @Test
    void I_am_close() {
        Cell cell = Cell.builder().mine(false).type(CellType.CELL_CLOSE).build();
        assertThat(cell.getType().name()).isEqualTo(CellType.CELL_CLOSE.name());
    }

    @Test
    void someone_putMe_a_flag() {
        Cell cell = Cell.builder().mine(false).type(CellType.CELL_FLAG).build();
        assertThat(cell.getType().name()).isEqualTo(CellType.CELL_FLAG.name());
    }

    @Test
    void I_am_exploded() {
        Cell cell = Cell.builder().mine(false).type(CellType.CELL_EXPLOSION).build();
        assertThat(cell.getType().name()).isEqualTo(CellType.CELL_EXPLOSION.name());
    }

    @Test
    void The_cell_is_open() {
        Cell cell = Cell.builder().mine(false).type(CellType.CELL_EXPLOSION).build();
        assertThat(cell.getType().name()).isEqualTo(CellType.CELL_EXPLOSION.name());
        assertFalse(cell.isMine());
    }

    @Test
    void The_cell_is_a_flag() {
        Cell cell = Cell.builder().mine(false).type(CellType.CELL_FLAG).build();
        assertThat(cell.getType().name()).isEqualTo(CellType.CELL_FLAG.name());
        assertFalse(cell.isMine());
    }

    @Test
    void Quit_a_flag_from_cell() {
        Cell cell = Cell.builder().mine(true).type(CellType.CELL_FLAG).build();
        assertThat(cell.getType().name()).isEqualTo(CellType.CELL_FLAG.name());
        assertTrue(cell.isMine());
    }

    @Test
    void num_of_neighborhood() {
        Cell cell = Cell.builder().mine(false).type(CellType.CELL_FLAG).minesInMyNeighbour(4).build();
        assertThat(cell.getType().name()).isEqualTo(CellType.CELL_FLAG.name());
        assertFalse(cell.isMine());
        assertThat(cell.getMinesInMyNeighbour()).isEqualTo(4);
    }
} 
