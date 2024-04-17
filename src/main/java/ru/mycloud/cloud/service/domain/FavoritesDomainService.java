package ru.mycloud.cloud.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.favorites.FavoritesAddRequest;
import ru.mycloud.cloud.dto.response.favorites.FavoritesResponse;
import ru.mycloud.cloud.dto.response.file.FileResponse;
import ru.mycloud.cloud.mapper.favorites.FavoritesMapper;
import ru.mycloud.cloud.mapper.favorites.FavoritesMerger;
import ru.mycloud.cloud.mapper.favorites.FavoritesResponseMapper;
import ru.mycloud.cloud.repository.file.FavoritesRepository;

import java.util.List;

/**
 *
 * Доменный сервис для управления сущностью Favorites
 * @author IrinaWerner
 * @see ru.mycloud.cloud.entity.file.Favorites*/
@RequiredArgsConstructor
@Service
public class FavoritesDomainService {
    private final FavoritesRepository repository;
    private final FavoritesResponseMapper responseMapper;
    private final FavoritesMapper mapper;
    private final FavoritesMerger merger;

    /**
     * Сервис для сохранения избранного
     * @param request Данные для создания избранного
     * @return id сохранённого избранного
     */
    @Transactional
    public Long addFavorite(FavoritesAddRequest request) {
        return repository.save(mapper.from(request)).getId();
    }

    /**
     * Получение избранного по id
     * @param id id запрашиваемого избранного
     * @return всех данных избранного
     */
    @Transactional
    public FavoritesResponse getFavoriteById(Long id) {
        return responseMapper.from(repository.getReferenceById(id));
    }

    /**
     * Получение всех объектов категории "Избранное"
     * @return список избранного {@link FileResponse}
     */
    @Transactional
    public List<FavoritesResponse> getAllFavorites() {
        return responseMapper.from(repository.findAll());
    }

    /**
     * Редактирование избранного
     * @param request данные для изменения избранного
     * @return отрадактированного избранного
     */
    @Transactional
    public Long editFavorite(FavoritesAddRequest request) {
        var favorites = repository.getReferenceById(request.getFavoritesId());
        merger.merge(favorites, request);
        return repository.save(favorites).getId();
    }

    /**
     * Удаление избранного по id
     * @param id избранного
     */
    @Transactional
    public void deleteFavorite(Long id) {
        repository.deleteById(id);
    }

}
