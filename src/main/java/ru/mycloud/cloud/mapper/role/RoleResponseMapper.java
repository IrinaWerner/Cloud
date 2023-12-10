package ru.mycloud.cloud.mapper.role;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.response.role.RoleResponse;
import ru.mycloud.cloud.entity.role.Role;
import ru.mycloud.cloud.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class RoleResponseMapper implements Mapper<RoleResponse, Role> {

    @Override
    public RoleResponse from(Role source) {
        return new RoleResponse()
                .setRoleId(source.getId())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
