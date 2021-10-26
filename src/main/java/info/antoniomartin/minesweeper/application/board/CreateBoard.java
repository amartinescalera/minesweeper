package info.antoniomartin.minesweeper.application.board;

public interface CreateBoard {
    BoardResponse create(String userId, int row, int col, int numberOfMines);
}
