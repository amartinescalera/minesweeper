package info.antoniomartin.springdemo.application.user;

import info.antoniomartin.springdemo.insfrastructure.h2.user.GetAllUserDAO;
import info.antoniomartin.springdemo.insfrastructure.h2.user.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class UserService implements GetAllUser {

    private final GetAllUserDAO dao;

    @Override
    public List<UserResponse> getAll() {
        List<UserEntity> entityList = dao.getUserList();
        return CollectionUtils.isEmpty(entityList) ?
            Collections.emptyList() :
            entityList.stream().map(entity -> UserResponse.builder()
                .id(entity.getId()).name(entity.getName()).email(entity.getEmail()).build())
                .collect(Collectors.toList());
    }
}
