package info.antoniomartin.springdemo.application.user;

import info.antoniomartin.springdemo.insfrastructure.h2.user.GetAllUserDAO;
import info.antoniomartin.springdemo.insfrastructure.h2.user.UserEntity;
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
class UserServiceTest {

    @Mock
    private GetAllUserDAO dao;

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(dao);
    }

    @Test
    void should_returnUserResponse_when_getAll() {
        //given
        List<UserEntity> userResponseMock = List.of(
            UserEntity.builder().id("TestUser1").name("TestName1").email("test1@test").build(),
            UserEntity.builder().id("TestUser2").name("TestName2").email("test2@test").build());

        when(dao.getUserList()).thenReturn(userResponseMock);

        //when
        List<UserResponse> userResponseList = userService.getAll();

        //then
        assertThat(userResponseList)
            .extracting("id", "name", "email")
            .contains(
                tuple("TestUser1", "TestName1", "test1@test"),
                tuple("TestUser2", "TestName2", "test2@test")
            );
    }
}