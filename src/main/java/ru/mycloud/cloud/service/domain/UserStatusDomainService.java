package ru.mycloud.cloud.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.entity.user.UserStatus;
import ru.mycloud.cloud.repository.user.UserStatusRepository;

import java.util.List;

/**
 * Доменный сервис для управления сущностью UserStatus
 *
 * @author IrinaWerner
 * @see ru.mycloud.cloud.entity.user.UserStatus
 */
@Service
@RequiredArgsConstructor
public class UserStatusDomainService {

    private final UserStatusRepository repository;

    /**
     * Сервис получения статуса пользователя
     * @param id статуса
     * @return  Возвращает
     * */
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
