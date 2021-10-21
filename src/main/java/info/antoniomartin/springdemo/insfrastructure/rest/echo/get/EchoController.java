package info.antoniomartin.springdemo.insfrastructure.rest.echo.get;

import info.antoniomartin.springdemo.application.echo.CreateEchoService;
import info.antoniomartin.springdemo.application.echo.EchoResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RestController
public class EchoController {

    private final CreateEchoService service;

    @GetMapping("/echo")
    public ResponseEntity<EchoResponse> getEcho() {
        EchoResponse response = service.createEcho();
        log.info("{}", response);
        return ResponseEntity.ok(response);
    }
}
