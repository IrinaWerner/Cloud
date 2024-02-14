package ru.mycloud.cloud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mycloud.cloud.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;






}
