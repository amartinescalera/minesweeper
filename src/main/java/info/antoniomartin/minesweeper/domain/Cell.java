package info.antoniomartin.minesweeper.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Cell {

    private final boolean mine;
    private final CellType type;
    private final int minesInMyNeighbour;
}
