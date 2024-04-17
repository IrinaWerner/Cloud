package ru.mycloud.cloud.mapper.favorites;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.response.favorites.FavoritesResponse;
import ru.mycloud.cloud.entity.file.Favorites;
import ru.mycloud.cloud.mapper.Mapper;
import ru.mycloud.cloud.mapper.file.FileResponseMapper;
import ru.mycloud.cloud.mapper.user.UserResponseMapper;

@RequiredArgsConstructor
@Service
public class FavoritesResponseMapper implements Mapper<FavoritesResponse, Favorites> {

    private final FileResponseMapper fileResponseMapper;
    private final UserResponseMapper userResponseMapper;
    @Override
    public FavoritesResponse from(Favorites source) {
        return new FavoritesResponse()
                .setFavoritesId(source.getId())
                .setFile(fileResponseMapper.from(source.getFile()))
                .setUser(userResponseMapper.from(source.getUser()))
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
