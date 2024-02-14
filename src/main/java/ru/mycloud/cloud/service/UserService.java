package ru.mycloud.cloud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.service.domain.UserDomainService;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserDomainService userDomainService;





}
