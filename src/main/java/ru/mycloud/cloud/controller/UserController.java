package ru.mycloud.cloud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.mycloud.cloud.dto.request.user.UserAddRequest;
import ru.mycloud.cloud.dto.response.ResponseBody;
import ru.mycloud.cloud.dto.response.user.UserResponse;
import ru.mycloud.cloud.service.UserService;


import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;


    public static final String USER = "/api/v1/user/{id}";
    public static final String USERS = "/api/v1/user";


    @PostMapping(
            value = USERS,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    ResponseBody<Object> addUser(@RequestBody UserAddRequest request){

        ResponseBody<Object> response ;

        try {
            response = ResponseBody.builder()
                    .success(true)
                    .message(service.addUser(request))
                    .data(null)
                    .build();

        }
        catch (Exception e) {
            response = ResponseBody.builder()
                    .success(false)
                    .message(e.getMessage())
                    .data(null)
                    .build();
        }


        return response;
    }

    @GetMapping(
            value = USER,
            produces = APPLICATION_JSON_VALUE
    )
    ResponseBody<UserResponse> getUser(@PathVariable("id") Long id){

        ResponseBody<UserResponse> response ;
        try {
            response = ResponseBody.<UserResponse>builder()
                    .success(true)
                    .message(null)
                    .data(service.getUser(id))
                    .build();

        }
        catch (Exception e) {
            response = ResponseBody.<UserResponse>builder()
                    .success(false)
                    .message(e.getMessage())
                    .data(null)
                    .build();
        }
        return response;

    }

    @GetMapping(
            value = USERS,
            produces = APPLICATION_JSON_VALUE
    )
    ResponseBody<List<UserResponse>> getUsers (){

        ResponseBody<List<UserResponse>> response ;
        try {
            response = ResponseBody.<List<UserResponse>>builder()
                    .success(true)
                    .message(null)
                    .data(service.getUsers())
                    .build();

        }
        catch (Exception e) {
            response = ResponseBody.<List<UserResponse>>builder()
                    .success(false)
                    .message(e.getMessage())
                    .data(null)
                    .build();
        }
        return response;
    }

    @DeleteMapping(
            value = USER,
            produces = APPLICATION_JSON_VALUE)

    ResponseBody<Object> deleteUser(@PathVariable("id") Long id){

        ResponseBody<Object> response ;

        try {
            response = ResponseBody.builder()
                    .success(true)
                    .message(service.deleteUser(id))
                    .data(null)
                    .build();

        }
        catch (Exception e) {
            response = ResponseBody.builder()
                    .success(false)
                    .message(e.getMessage())
                    .data(null)
                    .build();
        }


        return response;

    }

    @PutMapping(
            value = USER,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    ResponseBody<Object> editUser(@PathVariable(name = "id") Long id,  @RequestBody UserAddRequest request){

        ResponseBody<Object> response ;

        try {
            response = ResponseBody.builder()
                    .success(true)
                    .message(service.editUser(id,request))
                    .data(null)
                    .build();

        }
        catch (Exception e) {
            response = ResponseBody.builder()
                    .success(false)
                    .message(e.getMessage())
                    .data(null)
                    .build();
        }


        return response;
    }



}
