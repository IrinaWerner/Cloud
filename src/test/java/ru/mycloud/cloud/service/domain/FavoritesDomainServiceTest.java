package ru.mycloud.cloud.service.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mycloud.cloud.dto.request.favorites.FavoritesAddRequest;
import ru.mycloud.cloud.dto.response.favorites.FavoritesResponse;
import ru.mycloud.cloud.entity.file.Favorites;
import ru.mycloud.cloud.mapper.favorites.FavoritesMapper;
import ru.mycloud.cloud.mapper.favorites.FavoritesMerger;
import ru.mycloud.cloud.mapper.favorites.FavoritesResponseMapper;
import ru.mycloud.cloud.repository.file.FavoritesRepository;
import java.util.Collections;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class FavoritesDomainServiceTest {
    @Mock
    private FavoritesRepository repository;
    @Mock
    private FavoritesResponseMapper responseMapper;
    @Mock
    private FavoritesMapper mapper;
    @Mock
    private FavoritesMerger merger;
    @InjectMocks
    private FavoritesDomainService favoritesDomainService;

    private final static Long ID = 1L;

    @Test
    void addFavoriteTest() {
        when(repository.save(any())).thenReturn(new Favorites(ID));
        when(mapper.from(any(FavoritesAddRequest.class))).thenReturn(new Favorites(ID));

        var result = favoritesDomainService.addFavorite(getFavoritesAddRequest());

        Assertions.assertThat(result).isNotNull();
        Mockito.verify(repository).save(any());
        Mockito.verify(mapper).from(any(FavoritesAddRequest.class));
        Mockito.verifyNoMoreInteractions(repository, mapper);
        Mockito.verifyNoInteractions(merger, responseMapper);
    }

    @Test
    void getFavoriteByIdTest(){
        Mockito.when(repository.getReferenceById(anyLong())).thenReturn(getFavorite());
        Mockito.when(responseMapper.from(any(Favorites.class))).thenReturn(getFavoritesResponse());

        var result = favoritesDomainService.getFavoriteById(ID);

        Assertions.assertThat(result).isNotNull();

        verify(repository).getReferenceById(anyLong());
        verify(responseMapper).from(any(Favorites.class));
        verifyNoMoreInteractions(repository, responseMapper);
        verifyNoInteractions(merger, mapper);
    }

    @Test
    void getAllFavoritesTest() {
        Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(getFavorite()));
        Mockito.when(responseMapper.from(anyList())).thenReturn(Collections.singletonList(getFavoritesResponse()));

        var result = favoritesDomainService.getAllFavorites();

        Assertions.assertThat(result).isNotNull();

        verify(repository).findAll();
        verify(responseMapper).from(anyList());
        verifyNoMoreInteractions(repository, responseMapper);
        verifyNoInteractions(merger, mapper);
    }

    @Test
    void editFavoriteTest(){
        Mockito.when(repository.getReferenceById(anyLong())).thenReturn(getFavorite());
        Mockito.when(repository.save(any())).thenReturn(getFavorite());
        Mockito.when(merger.merge(any(), any())).thenReturn(getFavorite());

        var result = favoritesDomainService.editFavorite(getFavoritesAddRequest());

        Assertions.assertThat(result).isEqualTo(ID);

        verify(repository).getReferenceById(anyLong());
        verify(merger).merge(any(), any());
        verify(repository).save(any());
        verifyNoMoreInteractions(repository, merger);
        verifyNoInteractions(responseMapper, mapper);
    }

    @Test
    void deleteFavoriteTest() {
        favoritesDomainService.deleteFavorite(ID);
        verify(repository).deleteById(anyLong());
        verifyNoMoreInteractions(repository);
        verifyNoInteractions(merger, mapper, responseMapper);

    }

    private FavoritesResponse getFavoritesResponse(){
        return new FavoritesResponse().setFavoritesId(ID);
    }

    private FavoritesAddRequest getFavoritesAddRequest() {
        return new FavoritesAddRequest().setFavoritesId(ID);
    }

    private Favorites getFavorite() {
        return new Favorites(ID);
    }
}
