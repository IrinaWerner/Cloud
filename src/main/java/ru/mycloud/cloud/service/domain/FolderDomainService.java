package ru.mycloud.cloud.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.folder.FolderAddRequest;
import ru.mycloud.cloud.dto.response.file.FileResponse;
import ru.mycloud.cloud.dto.response.folder.FolderResponse;
import ru.mycloud.cloud.mapper.folder.FolderMapper;
import ru.mycloud.cloud.mapper.folder.FolderMerger;
import ru.mycloud.cloud.mapper.folder.FolderResponseMapper;
import ru.mycloud.cloud.repository.file.FolderRepository;

import java.util.List;

/**
 * Доменный сервис для управления сущностью Folder
 *
 * @author IrinaWerner
 * @see ru.mycloud.cloud.entity.file.Folder
 */

@RequiredArgsConstructor
@Service

public class FolderDomainService {

    private final FolderRepository repository;
    private final FolderResponseMapper responseMapper;
    private final FolderMapper mapper;
    private final FolderMerger merger;

    /**
     * Сервис для сохранения папки
     * @param request Данные для создания папки
     * @return id сохранённого папки
     */
    @Transactional
    public Long addFolder(FolderAddRequest request) {
        return repository.save(mapper.from(request)).getId();
    }

    /**
     * Получение папки по id
     * @param id id запрашиваемого файла
     * @return всех данных файла
     */
    @Transactional
    public FolderResponse getFolderById(Long id){
        return responseMapper.from(repository.getReferenceById(id));
    }

    /**
     * Получение всех файлов
     * @return список файлов {@link FileResponse}
     */
    @Transactional
    public List<FolderResponse> getAllFolder(){
        return responseMapper.from(repository.findAll());
    }

    /**
     * Редактирование файла
     * @param request данные для изменения файла
     * @return отрадактированного файла
     */
    @Transactional
    public Long editFolder(FolderAddRequest request){
        var folder = repository.getReferenceById(request.getFolderId());
        merger.merge(folder, request);
        return repository.save(folder).getId();
    }

    /**
     * Удаление файла по id
     * @param id файла
     */
    @Transactional
    public void deleteFolder(Long id){
        repository.deleteById(id);
    }




}
