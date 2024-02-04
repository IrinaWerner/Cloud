package ru.mycloud.cloud.dto.request.user;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
public class UserAddRequest {
    private Long userId;
    private String login;
    private String password;
    private String fullName;

}
