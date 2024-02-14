package ru.mycloud.cloud.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.role.RoleAddRequest;
import ru.mycloud.cloud.dto.response.role.RoleResponse;
import ru.mycloud.cloud.mapper.role.RoleMapper;
import ru.mycloud.cloud.mapper.role.RoleMerger;
import ru.mycloud.cloud.mapper.role.RoleResponseMapper;
import ru.mycloud.cloud.repository.RoleRepository;
import java.util.List;

/**
 *
 * Доменный сервис для управлениясущностью Role
 * @author IrinaWerner
 * @see ru.mycloud.cloud.entity.role.Role*/


@Service
@RequiredArgsConstructor
public class RoleDomainService {
    private final RoleRepository repository;
    private final RoleResponseMapper roleResponseMapper;
    private final RoleMapper roleMapper;
    private final RoleMerger roleMerger;

    /**
     * Сервис для получения роли по id
     * @param id Id сущность Role
     * @return Возвращает сущность Role в формате {@link RoleResponse}
     */

    @Transactional
    public RoleResponse getRole(Long id){ return roleResponseMapper.from(repository.getReferenceById(id));}

    /**
     * Сервис для получения всех объектов сущности Role
     * @return Возвращает список сущностей Role в формате {@link RoleResponse}
     */
    @Transactional
    public List<RoleResponse> getAllRole(){return roleResponseMapper.from(repository.findAll());}

    /**
     * Сервис для удаления роли по id
     * @param id Id сущность Role
     */
    @Transactional
    public void deleteRole(Long id){
        repository.deleteById(id);
    }

    /**
     * Сервис для получения сущность Role по имени
     * @param name Имя сущность Role
     * @return Возвращает список сущностей Role в формате {@link RoleResponse}
     */

    @Transactional
    public List<RoleResponse> getRolesByName(String name){return roleResponseMapper.from(repository.getRoleByName(name));}

    /**
     * Сервис для создания новой роли
     * @param request  Данные для создания роли
     * @return Возвращает Id созданной роли
     */
    @Transactional
    public Long addRole(RoleAddRequest request){
        var role = roleMapper.from(request);
        return repository.save(role).getId();
    }

    /**
     * Сервис для редактирования существующей роли
     * @param request  Данные для редактирования роли
     * @return Возвращает Id отредактированной роли
     */
    @Transactional
    public Long editRole(RoleAddRequest request){
        var role = repository.getReferenceById(request.getRoleId());
        roleMerger.merge(role, request);
        return repository.save(role).getId();
    }

}
