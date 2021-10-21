package info.antoniomartin.springdemo.insfrastructure.rest.echo.get;

import info.antoniomartin.springdemo.application.echo.CreateEchoService;
import info.antoniomartin.springdemo.application.echo.EchoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EchoControllerTest {

    @Mock
    private CreateEchoService service;

    private EchoController echo;

    @BeforeEach
    void setUp() {
        echo = new EchoController(service);
    }

    @Test
    void should_returnAString_when_echo() {
        //given
        EchoResponse resp = EchoResponse.builder().msg("Hello Application").time(0L).build();
        when(service.createEcho()).thenReturn(resp);

        //when
        ResponseEntity<EchoResponse> response = echo.getEcho();

        //then
        EchoResponse echo = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(echo);
        assertThat(echo.getMsg()).isEqualTo("Hello Application");
        assertThat(echo.getTime()).isZero();
    }
}
