package ru.mycloud.cloud.mapper.role;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.role.RoleAddRequest;
import ru.mycloud.cloud.entity.role.Role;
import ru.mycloud.cloud.mapper.Merger;

@Service
@RequiredArgsConstructor
public class RoleMerger implements Merger<Role, RoleAddRequest> {
    @Override
    public Role merge(Role target, RoleAddRequest source) {
        return target.setName(source.getName())
                .setDescription(source.getDescription());
    }
}
