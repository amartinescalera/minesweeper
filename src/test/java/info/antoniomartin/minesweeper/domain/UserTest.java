package info.antoniomartin.minesweeper.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserTest {

    @Test
    void should_initialize_user_when_start() {
        //given
        String id = "user@fake";
        String name = "name";
        String email  = "user@fake";
        String password  = "I am fake";

        //when
        User user = User.builder()
            .id(id)
            .name(name)
            .email(email)
            .password(password)
            .build();

        //then
        assertThat(user.getId()).isEqualTo(id);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getPassword()).isEqualTo(password);
    }

} 
