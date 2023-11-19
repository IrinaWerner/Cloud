package ru.mycloud.cloud.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.entity.role.Role;
import ru.mycloud.cloud.repository.RoleRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleDomainService {
    private final RoleRepository repository;

    @Transactional
    public Role getRole(Long id){
        return repository.getReferenceById(id);
    }

    @Transactional
    public List<Role> getAllRole(){
        return repository.findAll();
    }

    @Transactional
    public void deleteRole(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public List<Role> getRolesByName(String name){
        return repository.getRoleByName(name);
    }
}
