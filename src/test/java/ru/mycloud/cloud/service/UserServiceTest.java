package ru.mycloud.cloud.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mycloud.cloud.dto.request.user.UserAddRequest;
import ru.mycloud.cloud.dto.response.user.UserResponse;
import ru.mycloud.cloud.service.domain.UserDomainService;

import java.security.InvalidParameterException;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserDomainService userDomainService;
    @InjectMocks
    private UserService userService;

    private static final String LOGIN = "RaitoWerner";

    private static final Long ID = 1L;

    @Test
    void addUserTest() {
        Mockito.when(userDomainService.userLoginExists(any())).thenReturn(false);

        var result = userService.addUser(getRequest("irina12345lol!"));

        Assertions.assertThat(result).isEqualTo("Пользователь успешно создан");

        Mockito.verify(userDomainService).addUser(any());
        Mockito.verify(userDomainService).userLoginExists(any());
        Mockito.verifyNoMoreInteractions(userDomainService);
    }

    @Test
    void addUserFailingLoginTest() {
        Mockito.when(userDomainService.userLoginExists(any())).thenReturn(true);

        var request = getRequest("irina12345lol!");

        Assertions.assertThatThrownBy(() -> userService.addUser(request))
                .hasMessage("Логин уже занят!")
                .isInstanceOf(InvalidParameterException.class);

        Mockito.verify(userDomainService).userLoginExists(any());
        Mockito.verifyNoMoreInteractions(userDomainService);
    }

    @Test
    void addUserFailingPasswordTest() {
        Mockito.when(userDomainService.userLoginExists(any())).thenReturn(false);

        var request = getRequest("irina1");

        Assertions.assertThatThrownBy(() -> userService.addUser(request))
                .hasMessage("Пароль должен быть не меньше 8 символов и содержать большие и маленькие латинские буквы, цифры, спец символы!")
                .isInstanceOf(InvalidParameterException.class);

        Mockito.verify(userDomainService).userLoginExists(any());
        Mockito.verifyNoMoreInteractions(userDomainService);
    }

    @Test
    void getUserTest() {
        Mockito.when(userDomainService.getUser(anyLong())).thenReturn(getUserResponse());

        var result = userService.getUser(ID);

        Assertions.assertThat(result.getUserId()).isEqualTo(ID);

        Mockito.verify(userDomainService).getUser(anyLong());
        Mockito.verifyNoMoreInteractions(userDomainService);
    }

    @Test
    void getUsersTest() {
        Mockito.when(userDomainService.getAllUser()).thenReturn(Collections.singletonList(getUserResponse()));

        var result = userService.getUsers();

        Assertions.assertThat(result).hasSize(1);

        Mockito.verify(userDomainService).getAllUser();
        Mockito.verifyNoMoreInteractions(userDomainService);
    }

    @Test
    void DeleteUserTest() {

        var result = userService.deleteUser(ID);

        Assertions.assertThat(result).isEqualTo("Пользователь успешно удален!");

        Mockito.verify(userDomainService).deleteUser(anyLong());
        Mockito.verifyNoMoreInteractions(userDomainService);
    }

    @Test
    void editUserTest() {

        var result = userService.editUser(ID, getRequest("irina12345lol!"));

        Assertions.assertThat(result).isEqualTo("Пользователь успешно изменен!");

        Mockito.verify(userDomainService).editUser(anyLong(), any());
        Mockito.verifyNoMoreInteractions(userDomainService);
    }

    @Test
    void editUserFailingPasswordTest() {

        var request = getRequest("ir");

        Assertions.assertThatThrownBy(() ->userService.editUser(ID, request))
                .hasMessage("Пароль должен быть не меньше 8 символов и содержать большие и маленькие латинские буквы, цифры, спец символы!")
                        .isInstanceOf(InvalidParameterException.class);


        Mockito.verifyNoInteractions(userDomainService);
    }


    private UserAddRequest getRequest(String password) {
        return new UserAddRequest()
                .setLogin(LOGIN)
                .setPassword(password);
    }

    private UserResponse getUserResponse() {
        return new UserResponse().setUserId(ID);
    }
}
