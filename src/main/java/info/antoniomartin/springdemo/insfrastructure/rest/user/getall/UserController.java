package info.antoniomartin.springdemo.insfrastructure.rest.user.getall;

import info.antoniomartin.springdemo.application.user.GetAllUser;
import info.antoniomartin.springdemo.application.user.UserResponse;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RestController
public class UserController {

    private final GetAllUser getAllUser;

    @GetMapping("/users")
    ResponseEntity<List<UserResponse>> getUserList() {
        List<UserResponse> responseList = getAllUser.getAll();
        log.info("{}", responseList);
        return ResponseEntity.ok(responseList);
    }
}
