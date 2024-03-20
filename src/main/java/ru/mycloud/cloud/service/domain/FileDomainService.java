package ru.mycloud.cloud.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.file.FileAddRequest;
import ru.mycloud.cloud.dto.response.file.FileResponse;
import ru.mycloud.cloud.mapper.file.FileMapper;
import ru.mycloud.cloud.mapper.file.FileMerger;
import ru.mycloud.cloud.mapper.file.FileResponseMapper;
import ru.mycloud.cloud.repository.file.FileRepository;

import java.util.List;

/**
 *
 * Доменный сервис для управления сущностью File
 * @author IrinaWerner
 * @see ru.mycloud.cloud.entity.file.File*/

@RequiredArgsConstructor
@Service
public class FileDomainService {


    private final FileRepository repository;
    private final FileResponseMapper responseMapper;
    private final FileMapper mapper;
    private final FileMerger merger;

    /**
     * Сервис для сохранения файла
     * @param request Данные для создания файла
     * @return id сохранённого файла
     */
    @Transactional
    public Long addFile(FileAddRequest request) {
        return repository.save(mapper.from(request)).getId();
    }

    /**
     * Получение файла по id
     * @param id id запрашиваемого файла
     * @return всех данных файла
     */
    @Transactional
    public FileResponse getFileById(Long id){
        return responseMapper.from(repository.getReferenceById(id));
    }

    /**
     * Получение всех файлов
     * @return список файлов {@link FileResponse}
     */
    @Transactional
    public List<FileResponse> getAllFile(){
        return responseMapper.from(repository.findAll());
    }

    /**
     * Редактирование файла
     * @param request данные для изменения файла
     * @return отрадактированного файла
     */
    @Transactional
    public Long editFile(FileAddRequest request){
        var file = repository.getReferenceById(request.getFileId());
        merger.merge(file, request);
        return repository.save(file).getId();
    }

    /**
     * Удаление файла по id
     * @param id файла
     */
    @Transactional
    public void deleteFile(Long id){
        repository.deleteById(id);
    }


}
