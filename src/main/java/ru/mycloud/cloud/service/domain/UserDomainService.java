package ru.mycloud.cloud.service.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.entity.user.User;
import ru.mycloud.cloud.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDomainService {

    private final UserRepository repository;


    public User getUser(Long userId){
       return   repository.getReferenceById(userId);
    }

}
