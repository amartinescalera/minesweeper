package info.antoniomartin.springdemo.application.echo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class EchoServiceImplTest {

    private EchoService echoService;
    
    @BeforeEach
    void setUp() {
        echoService = new EchoService();
    }

    @Test
    void should_returnAEchoResponse_when_callService() {
        //given
        //when
        EchoResponse response = echoService.createEcho();

        //then
        assertThat(response.getMsg()).isEqualTo("Hello Application");
    }
} 