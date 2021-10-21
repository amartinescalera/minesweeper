package info.antoniomartin.springdemo.insfrastructure.h2.user;

import java.util.List;

public interface GetAllUserDAO {
    List<UserEntity> getUserList();
}
