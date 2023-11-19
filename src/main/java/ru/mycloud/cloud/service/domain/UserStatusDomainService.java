package ru.mycloud.cloud.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.entity.user.UserStatus;
import ru.mycloud.cloud.repository.UserStatusRepository;

@Service
@RequiredArgsConstructor
public class UserStatusDomainService {

    private final UserStatusRepository repository;

    @Transactional
    public UserStatus getUserStatus(Long id){
      return repository.getReferenceById(id);

    }

}
