package info.antoniomartin.minesweeper.insfrastructure.h2.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Component
public class UserDAO implements GetAllUserDAO{

    private final UserRepository repository;

    @Override
    public List<UserEntity> getUserList() {
        return repository.findAll();
    }
}
