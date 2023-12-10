package ru.mycloud.cloud.mapper.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.user.UserAddRequest;
import ru.mycloud.cloud.entity.user.User;
import ru.mycloud.cloud.entity.user.UserStatus;
import ru.mycloud.cloud.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class UserMapper implements Mapper<User, UserAddRequest> {

    @Override
    public User from(UserAddRequest source) {
        return new User()
                .setLogin(source.getLogin())
                .setPassword(source.getPassword())
                .setFullName(source.getFullName())
                .setStatus(new UserStatus(0L));
    }
}
