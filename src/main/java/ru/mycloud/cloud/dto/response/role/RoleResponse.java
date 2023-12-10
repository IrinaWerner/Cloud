package ru.mycloud.cloud.dto.response.role;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@ToString

public class RoleResponse {

    private Long roleId;
    private String name;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;

}
