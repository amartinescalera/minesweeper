package info.antoniomartin.springdemo.application.echo;

import info.antoniomartin.springdemo.domain.Echo;
import org.springframework.stereotype.Service;

@Service
public class EchoService implements CreateEchoService {

    @Override
    public EchoResponse createEcho() {
        final Echo myEcho = Echo.builder().msg("Hello Application").time(System.currentTimeMillis()).build();
        return EchoResponse.builder().msg(myEcho.getMsg()).time(myEcho.getTime()).build();
    }
}
