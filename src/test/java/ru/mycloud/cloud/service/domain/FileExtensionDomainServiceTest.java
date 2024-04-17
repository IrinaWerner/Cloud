package ru.mycloud.cloud.service.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mycloud.cloud.dto.request.file_extension.FileExtensionAddRequest;
import ru.mycloud.cloud.dto.response.file_extension.FileExtensionResponse;
import ru.mycloud.cloud.entity.file.FileExtension;
import ru.mycloud.cloud.mapper.file_extension.FileExtensionMapper;
import ru.mycloud.cloud.mapper.file_extension.FileExtensionMerger;
import ru.mycloud.cloud.mapper.file_extension.FileExtensionResponseMapper;
import ru.mycloud.cloud.repository.file.FileExtensionRepository;


import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class FileExtensionDomainServiceTest {
    @Mock
    private FileExtensionRepository repository;
    @Mock
    private FileExtensionResponseMapper responseMapper;
    @Mock
    private FileExtensionMapper mapper;
    @Mock
    private FileExtensionMerger merger;
    @InjectMocks
    private FileExtensionDomainService fileExtensionDomainService;
    private final Long ID = 1L;

    @Test
    void addFileExtensionTest() {
        Mockito.when(mapper.from(any(FileExtensionAddRequest.class))).thenReturn(getFileExtension());
        Mockito.when(repository.save(any())).thenReturn(getFileExtension());

        var result = fileExtensionDomainService.addFileExtension(new FileExtensionAddRequest());

        Assertions.assertThat(result).isNotNull();
        verify(mapper).from(any(FileExtensionAddRequest.class));
        verify(repository).save(any());
        verifyNoMoreInteractions(repository, mapper);
        verifyNoInteractions(merger, responseMapper);
    }

    @Test
    void getFileExtensionByIdTest(){
        Mockito.when(repository.getReferenceById(anyLong())).thenReturn(getFileExtension());
        Mockito.when(responseMapper.from(any(FileExtension.class))).thenReturn(getFileExtensionResponse());

        var result = fileExtensionDomainService.getFileExtensionById(ID);

        Assertions.assertThat(result).isNotNull();

        verify(repository).getReferenceById(anyLong());
        verify(responseMapper).from(any(FileExtension.class));
        verifyNoMoreInteractions(repository, responseMapper);
        verifyNoInteractions(merger, mapper);
    }

    @Test
    void getAllFileExtensionTest() {
        Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(getFileExtension()));
        Mockito.when(responseMapper.from(anyList())).thenReturn(Collections.singletonList(getFileExtensionResponse()));

        var result = fileExtensionDomainService.getAllFileExtension();

        Assertions.assertThat(result).isNotNull();

        verify(repository).findAll();
        verify(responseMapper).from(anyList());
        verifyNoMoreInteractions(repository, responseMapper);
        verifyNoInteractions(merger, mapper);
    }

    @Test
    void editFileExtensionTest(){
        Mockito.when(repository.getReferenceById(anyLong())).thenReturn(getFileExtension());
        Mockito.when(repository.save(any())).thenReturn(getFileExtension());
        Mockito.when(merger.merge(any(), any())).thenReturn(getFileExtension());

        var result = fileExtensionDomainService.editFileExtension(getFileExtensionRequest());

        Assertions.assertThat(result).isEqualTo(ID);

        verify(repository).getReferenceById(anyLong());
        verify(merger).merge(any(), any());
        verify(repository).save(any());
        verifyNoMoreInteractions(repository, merger);
        verifyNoInteractions(responseMapper, mapper);
    }

    @Test
    void deleteFileExtensionTest() {
        fileExtensionDomainService.deleteFileExtension(ID);
        verify(repository).deleteById(anyLong());
        verifyNoMoreInteractions(repository);
        verifyNoInteractions(merger, mapper, responseMapper);

    }

    private FileExtension getFileExtension(){
        return new FileExtension(ID);
    }

    private FileExtensionResponse getFileExtensionResponse(){
        return new FileExtensionResponse().setId(ID);
    }

    private FileExtensionAddRequest getFileExtensionRequest() {
        return new FileExtensionAddRequest().setId(ID);
    }

}
