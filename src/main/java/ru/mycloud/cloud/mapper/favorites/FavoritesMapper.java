package ru.mycloud.cloud.mapper.favorites;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.favorites.FavoritesAddRequest;
import ru.mycloud.cloud.entity.file.Favorites;
import ru.mycloud.cloud.entity.file.File;
import ru.mycloud.cloud.entity.user.User;
import ru.mycloud.cloud.mapper.Mapper;

@RequiredArgsConstructor
@Service
public class FavoritesMapper implements Mapper<Favorites, FavoritesAddRequest> {

    @Override
    public Favorites from(FavoritesAddRequest source) {
        return new Favorites()
                .setFile(new File(source.getFileId()))
                .setUser(new User(source.getUserId()));
    }


}
