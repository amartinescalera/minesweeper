package info.antoniomartin.minesweeper.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigInteger;
import java.util.Objects;

@Builder
@Getter
public class Board {
    private final Integer rowNumber;
    private final Integer colNumber;
    private final Integer numberOfMines;
    private final Cell[][] myBoard;

    public int numberOfCells() {
        if (Objects.isNull(rowNumber) || Objects.isNull(colNumber)) {
            return 0;
        } else {
            return BigInteger.valueOf(rowNumber).multiply(BigInteger.valueOf(colNumber)).intValue();
        }
    }
}
