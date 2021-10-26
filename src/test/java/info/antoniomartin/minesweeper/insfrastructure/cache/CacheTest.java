package info.antoniomartin.minesweeper.insfrastructure.cache;

import info.antoniomartin.minesweeper.domain.Cell;
import info.antoniomartin.minesweeper.domain.CellType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testing cache function")
class CacheTest {

    private static final String PEPITO = "pepito";

    @Test
    @DisplayName("Adding a New User without board")
    void should_do_fine_when_add_a_new_user_without_board() {
        //given
        Cache cache = new Cache();

        //when
        cache.addUser(PEPITO);

        //then
        assertThat(cache.getUserBoard(PEPITO)).isEmpty();
    }

    @Test
    @DisplayName("Adding a New User with board")
    void should_do_fine_when_add_a_new_user_with_board() {
        //given
        Cache cache = new Cache();
        Cell[][] myCacheBoard = new Cell[3][3];

        //when
        cache.addUser(PEPITO, myCacheBoard);

        //then
        assertThat(cache.getUserBoard(PEPITO)).hasDimensions(3,3);
    }

    @Test
    @DisplayName("Update board for an User")
    void should_do_fine_when_update_board_for_an_user() {
        //given
        Cache cache = new Cache();
        Cell[][] myCacheBoard = new Cell[3][3];
        cache.addUser(PEPITO, myCacheBoard);

        Cell oldCell = cache.getUserBoard(PEPITO)[0][0];

        //when
        myCacheBoard[0][0] = Cell.builder().type(CellType.CELL_CLOSE).build();
        cache.updateBoard(PEPITO, myCacheBoard);

        Cell newCell = cache.getUserBoard(PEPITO)[0][0];

        //then
        assertThat(oldCell).isNull();
        assertThat(newCell.getType()).isEqualTo(CellType.CELL_CLOSE);
    }

    @Test
    @DisplayName("The User has a Board")
    void should_do_fine_when_user_has_a_board() {
        //given
        Cache cache = new Cache();
        Cell[][] myCacheBoard = new Cell[3][3];

        //when
        cache.addUser(PEPITO, myCacheBoard);

        //then
        assertThat(cache.hasBoard(PEPITO)).isTrue();
    }

    @Test
    @DisplayName("The User has not a Board")
    void should_do_fine_when_user_has_not_a_board() {
        //given
        Cache cache = new Cache();

        //when
        //then
        assertThat(cache.hasBoard("menganito")).isFalse();
    }

    @Test
    @DisplayName("The User does not exist")
    void should_do_fine_when_user_does_not_exist() {
        //given
        Cache cache = new Cache();

        //when
        cache.getUserBoard("menganito");

        //then
        assertThat(cache.hasBoard("menganito")).isTrue();
    }

    @Test
    @DisplayName("The User does not exist and we remove it")
    void should_do_fine_when_user_does_not_exist_and_remove_it() {
        //given
        Cache cache = new Cache();

        //when
        cache.removeUser("menganito");

        //then
        assertThat(cache.hasBoard("menganito")).isFalse();
    }

    @Test
    @DisplayName("The User exists and we remove it")
    void should_do_fine_when_user_exists_and_we_remove_it() {
        //given
        Cache cache = new Cache();
        Cell[][] myCacheBoard = new Cell[3][3];
        cache.addUser(PEPITO, myCacheBoard);

        //when
        cache.removeUser(PEPITO);

        //then
        assertThat(cache.hasBoard(PEPITO)).isFalse();
    }
}
