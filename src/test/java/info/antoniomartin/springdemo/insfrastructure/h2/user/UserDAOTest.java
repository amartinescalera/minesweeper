package info.antoniomartin.springdemo.insfrastructure.h2.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDAOTest {

    @Mock
    private UserRepository repository;
    private UserDAO dao;

    @BeforeEach
    void setUp() {
        dao = new UserDAO(repository);
    }

    @Test
    void should_returnUserEntity_when_getUserList() {
        //given
        UserEntity user = UserEntity.builder().id("test").name("test").email("test@test").build();
        when(dao.getUserList()).thenReturn(List.of(user));

        //when
        List<UserEntity> users = dao.getUserList();

        //then
        assertThat(users.size()).isEqualTo(1);
        Assertions.assertThat(users)
            .extracting("id", "name", "email")
            .contains(
                tuple("test", "test", "test@test")
            );
    }
}