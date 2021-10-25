package info.antoniomartin.minesweeper.insfrastructure.cache;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CacheTest {

    @Test
    void should_do_fine_when_add_a_new_user() {
        //given
        Cache cache = new Cache();

        //when
        cache.addUser("pepito");

        //then
        assertThat(cache.getUserBoard("pepito").length).isEqualTo(0);
    }
}
