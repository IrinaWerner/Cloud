package ru.mycloud.cloud.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.user.UserAddRequest;
import ru.mycloud.cloud.dto.response.user.UserResponse;
import ru.mycloud.cloud.mapper.user.UserMapper;
import ru.mycloud.cloud.mapper.user.UserMerger;
import ru.mycloud.cloud.mapper.user.UserResponseMapper;
import ru.mycloud.cloud.repository.user.UserRepository;

import java.util.List;

/**
 * Доменный сервис для управления сущностью User
 *
 * @author ledford
 * @see ru.mycloud.cloud.entity.user.User
 */


@Service
@RequiredArgsConstructor
public class UserDomainService {

    private final UserRepository repository;
    private final UserResponseMapper userResponseMapper;
    private final UserMapper userMapper;
    private final UserMerger merger;

    /**
     * Сервис добавления нового пользователя
     * @param request Данные для создания новой сущности User
     * @return  Возвращается id  созданной сущности
     * @throws RuntimeException Возникает исключение при такой то ситуации
     * */

    @Transactional
    public Long addUser(UserAddRequest request) {
        var user = userMapper.from(request);
        return repository.save(user).getId();
    }

    /**
     * Сервис добавления нового пользователя
     * @param userId Id сущности
     * @return   Возвращает сущность User в формате {@link UserResponse}
     * */

    @Transactional
    public UserResponse getUser(Long userId) {
        return userResponseMapper.from(repository.getReferenceById(userId));
    }


    /**
     * Сервис получения всех пользователей
     * @return  Возвращается список всех сущностей в формате {@link UserResponse}
     * */

    @Transactional
    public List<UserResponse> getAllUser() {
        return userResponseMapper.from(repository.findAll());

    }

    /**
     * Сервис удаления пользователя
     * @param id id пользователя
     * */

    @Transactional
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    /**
     * Сервис редактирования пользователя
     * @param request Данные для редактирования сущности User
     * */
    @Transactional
    public void editUser(UserAddRequest request) {
        var user = repository.getReferenceById(request.getUserId());
        repository.save(merger.merge(user, request));
    }

}
