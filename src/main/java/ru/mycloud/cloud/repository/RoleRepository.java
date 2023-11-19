package ru.mycloud.cloud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mycloud.cloud.entity.role.Role;

import java.util.List;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> getRoleByName(String name);
}
