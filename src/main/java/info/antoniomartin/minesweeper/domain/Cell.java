package info.antoniomartin.minesweeper.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Cell {

    private final Boolean mine;
    private final CellType type;

    private final Integer numNeighbour;
    private final Integer rowPosition;
    private final Integer columnPosition;
    private final Integer minesInMyNeighbour;
}
