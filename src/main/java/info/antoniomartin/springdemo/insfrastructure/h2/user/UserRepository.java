package info.antoniomartin.springdemo.insfrastructure.h2.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String>  {
}
