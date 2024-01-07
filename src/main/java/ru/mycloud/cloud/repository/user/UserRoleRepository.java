package ru.mycloud.cloud.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mycloud.cloud.entity.user.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
