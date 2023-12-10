package ru.mycloud.cloud.mapper.role;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.role.RoleAddRequest;
import ru.mycloud.cloud.entity.role.Role;
import ru.mycloud.cloud.mapper.Mapper;

@Service
@RequiredArgsConstructor

public class RoleMapper implements Mapper<Role, RoleAddRequest> {


    @Override
    public Role from(RoleAddRequest source) {
        return new Role()
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
