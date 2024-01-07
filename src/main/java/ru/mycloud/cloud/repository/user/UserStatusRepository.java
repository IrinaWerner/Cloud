package ru.mycloud.cloud.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.mycloud.cloud.entity.user.UserStatus;

import java.util.List;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatus, Long> {

    List<UserStatus> getUserStatusByName(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM REPOSITORY.USER_STATUS WHERE NAME = :name ")
    List<UserStatus>  getUserStatusByName2(@Param("name") String name);


}
