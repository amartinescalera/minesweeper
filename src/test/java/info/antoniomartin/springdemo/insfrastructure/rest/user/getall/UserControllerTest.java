package info.antoniomartin.springdemo.insfrastructure.rest.user.getall;

import info.antoniomartin.springdemo.application.user.GetAllUser;
import info.antoniomartin.springdemo.application.user.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    private UserController controller;

    @Mock
    private GetAllUser getAllUser;

    @BeforeEach
    void setUp() {
        controller = new UserController(getAllUser);
    }

    @Test
    void should_returnUserResponse_when_getUserList() {
        //given
        UserResponse uR1 = UserResponse.builder().id("a").name("Mock A").email("a@a.es").build();
        UserResponse uR2 = UserResponse.builder().id("b").name("Mock B").email("b@b.es").build();
        when(getAllUser.getAll()).thenReturn(List.of(uR1, uR2));

        //when
        ResponseEntity<List<UserResponse>> response = controller.getUserList();

        //then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertThat(response.getBody().size()).isEqualTo(2);
        assertThat(response.getBody())
            .extracting("id", "name", "email")
            .contains(
                tuple("a", "Mock A", "a@a.es"),
                tuple("b", "Mock B", "b@b.es")
            );
    }
}
