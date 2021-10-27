package info.antoniomartin.minesweeper.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BoardTest {

    @Test
    void should_initialize_board_when_start() {
        //given
        int rowNumber = 10;
        int colNumber = 20;
        int numberOfCells = 200;

        //when
        Board board = Board.builder()
            .rowNumber(rowNumber)
            .colNumber(colNumber)
            .myBoard(new Cell[rowNumber][colNumber])
            .build();

        //then
        assertThat(board.getRowNumber()).isEqualTo(rowNumber);
        assertThat(board.getColNumber()).isEqualTo(colNumber);
        assertThat(board.numberOfCells()).isEqualTo(numberOfCells);
        assertThat(board.getMyBoard()).isNotEmpty();
    }

    @Test
    void should_initialize_board_when_start_with_not_value() {
        //given
        //when
        Board board = Board.builder()
            .build();

        //then
        assertThat(board.getRowNumber()).isNull();
        assertThat(board.getColNumber()).isNull();
        assertThat(board.numberOfCells()).isZero();
    }
}
