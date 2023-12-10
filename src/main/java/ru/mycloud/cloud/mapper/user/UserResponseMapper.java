package ru.mycloud.cloud.mapper.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.response.user.UserResponse;
import ru.mycloud.cloud.entity.user.User;
import ru.mycloud.cloud.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class UserResponseMapper implements Mapper<UserResponse, User> {

    @Override
    public UserResponse from(User source) {
        return new UserResponse()
                .setUserId(source.getId())
                .setLogin(source.getLogin())
                .setFullName(source.getFullName())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
