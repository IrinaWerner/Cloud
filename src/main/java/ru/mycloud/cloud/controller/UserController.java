package ru.mycloud.cloud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.mycloud.cloud.dto.request.UserStatusRequest;
import ru.mycloud.cloud.entity.user.UserStatus;
import ru.mycloud.cloud.service.UserService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    private static final  String USER_STATUS_GET = "/api/v1/user-status/get";


    @PostMapping(
            value = USER_STATUS_GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)

    public UserStatus getUserStatus(@RequestBody UserStatusRequest request){
        return service.getUserStatus(request.getId());
    }

}
