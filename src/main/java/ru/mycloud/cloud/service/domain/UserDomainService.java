package ru.mycloud.cloud.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.user.UserAddRequest;
import ru.mycloud.cloud.dto.response.user.UserResponse;
import ru.mycloud.cloud.mapper.user.UserMapper;
import ru.mycloud.cloud.mapper.user.UserResponseMapper;
import ru.mycloud.cloud.repository.user.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDomainService {

    private final UserRepository repository;
    private final UserResponseMapper userResponseMapper;
    private final UserMapper userMapper;


    @Transactional
    public Long addUser(UserAddRequest request) {
        var user = userMapper.from(request);
        return repository.save(user).getId();
    }


    @Transactional
    public UserResponse getUser(Long userId) {
        return userResponseMapper.from(repository.getReferenceById(userId));
    }

    @Transactional
    public List<UserResponse> getAllUser() {
        return userResponseMapper.from(repository.findAll());

    }

    @Transactional
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }


}
