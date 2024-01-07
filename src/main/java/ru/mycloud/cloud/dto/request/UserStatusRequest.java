package ru.mycloud.cloud.dto.request;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class UserStatusRequest {
    private long id;
}
