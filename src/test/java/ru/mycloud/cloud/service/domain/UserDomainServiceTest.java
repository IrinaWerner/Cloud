package ru.mycloud.cloud.service.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mycloud.cloud.dto.request.user.UserAddRequest;
import ru.mycloud.cloud.dto.response.user.UserResponse;
import ru.mycloud.cloud.entity.user.User;
import ru.mycloud.cloud.mapper.user.UserMapper;
import ru.mycloud.cloud.mapper.user.UserMerger;
import ru.mycloud.cloud.mapper.user.UserResponseMapper;
import ru.mycloud.cloud.repository.user.UserRepository;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDomainServiceTest {

    @Mock
    private UserRepository repository;
    @Mock
    private UserResponseMapper userResponseMapper;
    @Mock
    private UserMapper userMapper;
    @Mock
    private UserMerger merger;

    @InjectMocks
    private UserDomainService domainService;

    private final Long ID = 0L;

    @Test
    void addUserTest(){

        when(userMapper.from((UserAddRequest) any())).thenReturn(new User(ID));
        when(repository.save(any())).thenReturn(new User(ID));

        var result = domainService.addUser(new UserAddRequest());

        assertThat(result).isEqualTo(ID);

        verify(userMapper).from((UserAddRequest) any());
        verify(repository).save(any());
        verifyNoMoreInteractions(userMapper, repository);
        verifyNoInteractions(userResponseMapper, merger);

    }

    @Test
    void getUserTest(){

        when(userResponseMapper.from((User) any())).thenReturn(new UserResponse().setUserId(ID));
        when(repository.getReferenceById(any())).thenReturn(new User(ID));

        var result = domainService.getUser(ID);

        assertThat(result.getUserId()).isEqualTo(ID);

        verify(userResponseMapper).from((User) any());
        verify(repository).getReferenceById(any());
        verifyNoMoreInteractions(userResponseMapper, repository);
        verifyNoInteractions(userMapper, merger);


    }

    @Test
    void getAllUserTest(){

        when(userResponseMapper.from((List<User>) any())).thenReturn(Collections.singletonList(new UserResponse()));
        when(repository.findAll()).thenReturn(Collections.singletonList(new User()));

        var result = domainService.getAllUser();

        assertThat(result.size()).isEqualTo(1);

        verify(userResponseMapper).from((List<User>) any());
        verify(repository).findAll();
        verifyNoMoreInteractions(userResponseMapper, repository);
        verifyNoInteractions(userMapper, merger);


    }

    @Test
    void deleteUserTest(){

        domainService.deleteUser(ID);

        verify(repository).deleteById(any());
        verifyNoMoreInteractions(repository);
        verifyNoInteractions(userMapper, userResponseMapper, merger);

    }

    @Test
    void editUserTest(){

        when(merger.merge(any(),any())).thenReturn(new User(ID));
        when(repository.getReferenceById(any())).thenReturn(new User(ID));

        domainService.editUser(new UserAddRequest());

        verify(merger).merge(any(),any());
        verify(repository).save(any());
        verify(repository).getReferenceById(any());
        verifyNoMoreInteractions(merger, repository);
        verifyNoInteractions(userResponseMapper, userMapper );

    }




}
