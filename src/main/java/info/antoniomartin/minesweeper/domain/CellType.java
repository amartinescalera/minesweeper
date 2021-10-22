package info.antoniomartin.minesweeper.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CellType {
    CELL_MINE,
    CELL_CLOSE,
    CELL_EXPLOSION,
    CELL_FLAG,
    CELL_OPEN

}
