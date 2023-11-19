package ru.mycloud.cloud.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.entity.user.User;
import ru.mycloud.cloud.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDomainService {

    private final UserRepository repository;

    @Transactional
    public User getUser(Long userId){
       return   repository.getReferenceById(userId);
    }

    @Transactional
    public List<User> getAllUser(){
        return repository.findAll();
    }

    @Transactional
    public void deleteUser(Long id){
        repository.deleteById(id);
    }


}
