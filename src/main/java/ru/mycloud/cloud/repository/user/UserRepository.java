package ru.mycloud.cloud.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mycloud.cloud.entity.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
