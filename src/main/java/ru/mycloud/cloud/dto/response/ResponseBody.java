package ru.mycloud.cloud.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class ResponseBody<T> {
    private Boolean success;
    private String message;
    private T data;
}
