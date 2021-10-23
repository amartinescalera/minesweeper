package info.antoniomartin.minesweeper.application.board;

import info.antoniomartin.minesweeper.domain.Cell;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BoardResponse {
    private final Integer rowNumber;
    private final Integer colNumber;
    private final Integer numberOfMines;
    private final Integer numberOfCells;
    private final Cell[][] myBoard;
}
