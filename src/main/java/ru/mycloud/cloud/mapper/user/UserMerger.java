package ru.mycloud.cloud.mapper.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.user.UserAddRequest;
import ru.mycloud.cloud.entity.user.User;
import ru.mycloud.cloud.mapper.Merger;
@Service
@RequiredArgsConstructor
public class UserMerger implements Merger<User, UserAddRequest> {
    @Override
    public User merge(User target, UserAddRequest source) {
        return target
                .setPassword(source.getPassword())
                .setFullName(source.getFullName());
    }
}
