package info.antoniomartin.minesweeper.insfrastructure.rest.board.getboard;

import info.antoniomartin.minesweeper.application.board.BoardResponse;
import info.antoniomartin.minesweeper.application.board.CreateBoard;
import info.antoniomartin.minesweeper.application.board.GetActiveBoard;
import info.antoniomartin.minesweeper.domain.Cell;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BoardControllerTest {

    private final String USER_ID = "userId";

    @InjectMocks
    private BoardController controller;

    @Mock
    private CreateBoard createBoard;

    @Mock
    private GetActiveBoard activeBoard;

    @Test
    void should_return_board_when_board_exist() {
        //given
        BoardResponse fakeResponse = BoardResponse.builder()
            .rowNumber(3)
            .colNumber(3)
            .numberOfCells(9)
            .numberOfMines(3)
            .myBoard(new Cell[3][3])
            .build();
        given(activeBoard.getActiveBoard(USER_ID)).willReturn(fakeResponse);

        //when
        ResponseEntity<BoardResponse> controllerResponse = controller.getBoard();

        //then
        assertThat(controllerResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(controllerResponse.getBody()).isEqualTo(fakeResponse);
    }

    @Test
    void should_create_board_when_board_does_not_exist() {
        //given
        final int fakeNumber = 10;
        final BoardResponse fakeResponse = BoardResponse.builder()
            .rowNumber(3)
            .colNumber(3)
            .numberOfCells(9)
            .numberOfMines(3)
            .myBoard(new Cell[3][3])
            .build();
        given(createBoard.create(USER_ID, fakeNumber, fakeNumber, fakeNumber)).willReturn(fakeResponse);

        //when
        ResponseEntity<BoardResponse> controllerResponse = controller.getBoard(fakeNumber, fakeNumber, fakeNumber);

        //then
        assertThat(controllerResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(controllerResponse.getBody()).isEqualTo(fakeResponse);
    }
}
