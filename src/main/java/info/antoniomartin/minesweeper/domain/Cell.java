package info.antoniomartin.minesweeper.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Cell {

    private final boolean mine;
    private final CellType type;

    private final int numNeighbour;
    private final int rowPosition;
    private final int columnPosition;
    private final int minesInMyNeighbour;
}
