package ru.mycloud.cloud.service.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mycloud.cloud.dto.request.file.FileAddRequest;
import ru.mycloud.cloud.dto.response.file.FileResponse;
import ru.mycloud.cloud.entity.file.File;
import ru.mycloud.cloud.mapper.file.FileMapper;
import ru.mycloud.cloud.mapper.file.FileMerger;
import ru.mycloud.cloud.mapper.file.FileResponseMapper;
import ru.mycloud.cloud.repository.file.FileRepository;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class FileDomainServiceTest {

    @Mock
    private FileRepository repository;
    @Mock
    private FileResponseMapper responseMapper;
    @Mock
    private FileMapper mapper;
    @Mock
    private FileMerger merger;
    @InjectMocks
    private FileDomainService fileDomainService;
    private final Long ID = 1L;

    @Test
    void addFileTest() {
        Mockito.when(mapper.from(any(FileAddRequest.class))).thenReturn(getFile());
        Mockito.when(repository.save(any())).thenReturn(getFile());

        var result = fileDomainService.addFile(new FileAddRequest());

        Assertions.assertThat(result).isNotNull();
        verify(mapper).from(any(FileAddRequest.class));
        verify(repository).save(any());
        verifyNoMoreInteractions(repository, mapper);
        verifyNoInteractions(merger, responseMapper);
    }

    @Test
    void getFileByIdTest(){
        Mockito.when(repository.getReferenceById(anyLong())).thenReturn(getFile());
        Mockito.when(responseMapper.from(any(File.class))).thenReturn(getFileResponse());

        var result = fileDomainService.getFileById(ID);

        Assertions.assertThat(result).isNotNull();

        verify(repository).getReferenceById(anyLong());
        verify(responseMapper).from(any(File.class));
        verifyNoMoreInteractions(repository, responseMapper);
        verifyNoInteractions(merger, mapper);
    }

    @Test
    void getAllFileTest() {
        Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(getFile()));
        Mockito.when(responseMapper.from(anyList())).thenReturn(Collections.singletonList(getFileResponse()));

        var result = fileDomainService.getAllFile();

        Assertions.assertThat(result).isNotNull();

        verify(repository).findAll();
        verify(responseMapper).from(anyList());
        verifyNoMoreInteractions(repository, responseMapper);
        verifyNoInteractions(merger, mapper);
    }

    @Test
    void editFileTest(){
        Mockito.when(repository.getReferenceById(anyLong())).thenReturn(getFile());
        Mockito.when(repository.save(any())).thenReturn(getFile());
        Mockito.when(merger.merge(any(), any())).thenReturn(getFile());

        var result = fileDomainService.editFile(getFileRequest());

        Assertions.assertThat(result).isEqualTo(ID);

        verify(repository).getReferenceById(anyLong());
        verify(merger).merge(any(), any());
        verify(repository).save(any());
        verifyNoMoreInteractions(repository, merger);
        verifyNoInteractions(responseMapper, mapper);
    }

    @Test
    void deleteFileTest() {
        fileDomainService.deleteFile(ID);
        verify(repository).deleteById(anyLong());
        verifyNoMoreInteractions(repository);
        verifyNoInteractions(merger, mapper, responseMapper);

    }

    private File getFile(){
        return new File(ID);
    }

    private FileResponse getFileResponse(){
        return new FileResponse().setFileId(ID);
    }

    private FileAddRequest getFileRequest() {
        return new FileAddRequest().setFileId(ID);
    }


}
