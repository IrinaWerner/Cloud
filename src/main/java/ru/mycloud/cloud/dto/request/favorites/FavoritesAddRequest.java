package ru.mycloud.cloud.dto.request.favorites;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FavoritesAddRequest {
    private Long favoritesId;
    private Long fileId;
    private Long userId;
}
