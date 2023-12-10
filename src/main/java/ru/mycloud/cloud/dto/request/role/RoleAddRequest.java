package ru.mycloud.cloud.dto.request.role;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@RequiredArgsConstructor
public class RoleAddRequest {
    private String name;
    private String description;
}
