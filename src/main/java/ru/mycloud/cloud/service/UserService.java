package ru.mycloud.cloud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.entity.user.UserStatus;
import ru.mycloud.cloud.service.domain.UserDomainService;
import ru.mycloud.cloud.service.domain.UserStatusDomainService;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserStatusDomainService userStatusDomainService;
    private final UserDomainService userDomainService;


    public UserStatus getUserUserStatus(Long statusId){
        return userStatusDomainService.getUserStatus(statusId);
    }


}
