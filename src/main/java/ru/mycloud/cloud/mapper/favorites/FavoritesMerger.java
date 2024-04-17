package ru.mycloud.cloud.mapper.favorites;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.favorites.FavoritesAddRequest;
import ru.mycloud.cloud.entity.file.Favorites;
import ru.mycloud.cloud.entity.file.File;
import ru.mycloud.cloud.entity.user.User;
import ru.mycloud.cloud.mapper.Merger;

@RequiredArgsConstructor
@Service
public class FavoritesMerger implements Merger<Favorites, FavoritesAddRequest> {


    @Override
    public Favorites merge(Favorites target, FavoritesAddRequest source) {
        return target.setFile(new File(source.getFileId()))
                .setUser(new User(source.getUserId()));
    }
}
