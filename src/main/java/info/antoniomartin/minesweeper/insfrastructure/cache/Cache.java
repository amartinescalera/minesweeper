package info.antoniomartin.minesweeper.insfrastructure.cache;

import info.antoniomartin.minesweeper.application.board.BoardResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Cache {

    BoardResponse theBoard = null;

}
