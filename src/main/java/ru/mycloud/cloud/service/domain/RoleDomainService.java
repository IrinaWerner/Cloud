package ru.mycloud.cloud.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.role.RoleAddRequest;
import ru.mycloud.cloud.dto.response.role.RoleResponse;
import ru.mycloud.cloud.mapper.role.RoleMapper;
import ru.mycloud.cloud.mapper.role.RoleResponseMapper;
import ru.mycloud.cloud.repository.RoleRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleDomainService {
    private final RoleRepository repository;
    private final RoleResponseMapper roleResponseMapper;
    private final RoleMapper roleMapper;

    @Transactional
    public RoleResponse getRole(Long id){ return roleResponseMapper.from(repository.getReferenceById(id));}

    @Transactional
    public List<RoleResponse> getAllRole(){return roleResponseMapper.from(repository.findAll());}

    @Transactional
    public void deleteRole(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public List<RoleResponse> getRolesByName(String name){return roleResponseMapper.from(repository.getRoleByName(name));}

    @Transactional
    public Long addRole(RoleAddRequest request){
        var role = roleMapper.from(request);
        return repository.save(role).getId();
    }
}
