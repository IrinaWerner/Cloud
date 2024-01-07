package ru.mycloud.cloud.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.entity.user.UserStatus;
import ru.mycloud.cloud.repository.user.UserStatusRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserStatusDomainService {

    private final UserStatusRepository repository;

    @Transactional
    public UserStatus getUserStatus(Long id){
      return repository.getReferenceById(id);

    }

    @Transactional
    public List<UserStatus> getAllUserStatus(){
        return repository.findAll();
    }

    @Transactional
    public void deleteUserStatusById(Long id){
        repository.deleteById(id);
    }



}
