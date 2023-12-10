package ru.mycloud.cloud.dto.response.user;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@ToString
public class UserResponse {

    private Long userId;
    private String login;
    private String fullName;
    private LocalDateTime created;
    private LocalDateTime modified;


}
