package info.antoniomartin.minesweeper.insfrastructure.cache;

import info.antoniomartin.minesweeper.domain.Cell;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class Cache {

    Map<String, Cell[][]> usersBoards;

    public Cache() {
        usersBoards = new HashMap<>();
    }

    public void addUser(String userId) {
        updateBoard(userId, new Cell[0][0]);
    }

    public void addUser(String userId, Cell[][] theBoard) {
        usersBoards.put(userId, theBoard);
    }

    public void updateBoard(String userId, Cell[][] theBoard) {
        if (usersBoards.containsKey(userId)) {
            usersBoards.put(userId, theBoard);
        } else {
            usersBoards.put(userId, new Cell[0][0]);
        }
    }

    public void removeUser(String userId) {
        usersBoards.remove(userId);
    }

    public Cell[][] getUserBoard(String userId) {
        if (!usersBoards.containsKey(userId)) {
            addUser(userId);
        }
        return usersBoards.get(userId);
    }

    public boolean hasBoard(final String userId) {
        return usersBoards.containsKey(userId);
    }
}
