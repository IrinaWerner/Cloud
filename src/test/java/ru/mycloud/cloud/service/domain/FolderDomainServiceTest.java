package ru.mycloud.cloud.service.domain;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mycloud.cloud.dto.request.folder.FolderAddRequest;
import ru.mycloud.cloud.dto.response.folder.FolderResponse;
import ru.mycloud.cloud.entity.file.Folder;
import ru.mycloud.cloud.mapper.folder.FolderMapper;
import ru.mycloud.cloud.mapper.folder.FolderMerger;
import ru.mycloud.cloud.mapper.folder.FolderResponseMapper;
import ru.mycloud.cloud.repository.file.FolderRepository;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

 class FolderDomainServiceTest {

    @Mock
    private  FolderRepository repository;
    @Mock
    private  FolderResponseMapper responseMapper;
    @Mock
    private  FolderMapper mapper;
    @Mock
    private  FolderMerger merger;

    @InjectMocks
    private FolderDomainService folderDomainService;

    private final Long ID = 1L;

    @Test
    void addFolderTest() {
       Mockito.when(repository.save(any())).thenReturn(getFolder());
       Mockito.when(mapper.from(any(FolderAddRequest.class))).thenReturn(getFolder());

       var result = folderDomainService.addFolder(getRequest());

       Assertions.assertThat(result).isNotNull().isEqualTo(ID);

       verify(repository).save(any());
       verify(mapper).from(any(FolderAddRequest.class));
       verifyNoMoreInteractions(repository, mapper);
       verifyNoInteractions(responseMapper, merger);

    }

    @Test
    void getFolderByIdTest() {
       Mockito.when(repository.getReferenceById(anyLong())).thenReturn(getFolder());
       Mockito.when(responseMapper.from(any(Folder.class))).thenReturn(getResponse());

       var result = folderDomainService.getFolderById(ID);

       Assertions.assertThat(result).isNotNull();

       verify(repository).getReferenceById(anyLong());
       verify(responseMapper).from(any(Folder.class));
       verifyNoMoreInteractions(repository, responseMapper);
       verifyNoInteractions(merger, mapper);
    }

    @Test
    void getAllFolderTest() {
       Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(getFolder()));
       Mockito.when(responseMapper.from(anyList())).thenReturn(Collections.singletonList(getResponse()));

       var result  = folderDomainService.getAllFolder();

       Assertions.assertThat(result).isNotNull().hasSize(1);

       verify(repository).findAll();
       verify(responseMapper).from(anyList());
       verifyNoMoreInteractions(repository, responseMapper);
       verifyNoInteractions(merger, mapper);
    }

    @Test
    void editFolderTest() {
       Mockito.when(repository.getReferenceById(anyLong())).thenReturn(getFolder());
       Mockito.when(merger.merge(any(), any())).thenReturn(getFolder());
       Mockito.when(repository.save(any())).thenReturn(getFolder());

       var result = folderDomainService.editFolder(getRequest());

       Assertions.assertThat(result).isNotNull().isEqualTo(ID);

       verify(repository).getReferenceById(anyLong());
       verify(merger).merge(any(), any());
       verify(repository).save(any());
       verifyNoMoreInteractions(repository, merger);
       verifyNoInteractions(responseMapper, mapper);
    }

   @Test
   void deleteFolderTest() {
       folderDomainService.deleteFolder(ID);

       verify(repository).deleteById(ID);
       verifyNoMoreInteractions(repository);
       verifyNoInteractions(mapper, responseMapper, merger);
   }

    private FolderAddRequest getRequest() {
       return new FolderAddRequest().setFolderId(ID);
    }

    private Folder getFolder() {
       return new Folder(ID);
    }

    private FolderResponse getResponse() {
       return new FolderResponse().setFolderId(ID);
    }







}
