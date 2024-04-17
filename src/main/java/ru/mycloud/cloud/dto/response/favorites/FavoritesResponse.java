package ru.mycloud.cloud.dto.response.favorites;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.mycloud.cloud.dto.response.file.FileResponse;
import ru.mycloud.cloud.dto.response.user.UserResponse;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class FavoritesResponse {
    private Long favoritesId;
    private FileResponse file;
    private UserResponse user;
    private LocalDateTime created;
    private LocalDateTime modified;
}
