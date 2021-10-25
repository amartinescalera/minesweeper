package info.antoniomartin.minesweeper.application.board;

public interface CreateBoard {
    BoardResponse create(int row, int col, int numberOfMines);
}
