package ru.mycloud.cloud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.user.UserAddRequest;
import ru.mycloud.cloud.dto.response.user.UserResponse;
import ru.mycloud.cloud.service.domain.UserDomainService;

import java.security.InvalidParameterException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserDomainService userDomainService;

    private static final String PASSWORD_REG = "^.*(?=.{8,})(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!#$%&? \"]).*$";

    public String addUser(UserAddRequest request) {

        if (userDomainService.userLoginExists(request.getLogin()))
            throw new InvalidParameterException("Логин уже занят!");


        if (!request.getPassword().matches(PASSWORD_REG))
            throw new InvalidParameterException("Пароль должен быть не меньше 8 символов и содержать большие и маленькие латинские буквы, цифры, спец символы!");

        userDomainService.addUser(request);
        return "Пользователь успешно создан";
    }


    public UserResponse getUser(Long id) {
        return userDomainService.getUser(id);
    }

    public List<UserResponse> getUsers() {
        return userDomainService.getAllUser();
    }

    public String deleteUser(Long id) {

        userDomainService.deleteUser(id);
        return "Пользователь успешно удален!";

    }

    public String editUser(Long id, UserAddRequest request) {

        if (!request.getPassword().matches(PASSWORD_REG))
            throw new InvalidParameterException("Пароль должен быть не меньше 8 символов и содержать большие и маленькие латинские буквы, цифры, спец символы!");

        userDomainService.editUser(id,request);
        return "Пользователь успешно изменен!";
    }
}
