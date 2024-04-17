package ru.mycloud.cloud.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ru.mycloud.cloud.dto.request.file_extension.FileExtensionAddRequest;

import ru.mycloud.cloud.dto.response.file_extension.FileExtensionResponse;
import ru.mycloud.cloud.mapper.file_extension.FileExtensionMapper;
import ru.mycloud.cloud.mapper.file_extension.FileExtensionMerger;
import ru.mycloud.cloud.mapper.file_extension.FileExtensionResponseMapper;
import ru.mycloud.cloud.repository.file.FileExtensionRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class FileExtensionDomainService {

    private final FileExtensionRepository repository;
    private final FileExtensionResponseMapper responseMapper;
    private final FileExtensionMapper mapper;
    private final FileExtensionMerger merger;

    /**
     * Сервис для сохранения расширения файла
     * @param request Данные для создания расширения файла
     * @return id сохранённого расширения файла
     */
    @Transactional
    public Long addFileExtension(FileExtensionAddRequest request) {
        return repository.save(mapper.from(request)).getId();
    }

    /**
     * Получение расширения файла по id
     * @param id id запрашиваемого расширения файла
     * @return всех данных расширения файла
     */
    @Transactional
    public FileExtensionResponse getFileExtensionById(Long id){
        return responseMapper.from(repository.getReferenceById(id));
    }

    /**
     * Получение всех расширений
     * @return список расширений {@link FileExtensionResponse}
     */
    @Transactional
    public List<FileExtensionResponse> getAllFileExtension(){
        return responseMapper.from(repository.findAll());
    }

    /**
     * Редактирование расширения
     * @param request данные для изменения расширения
     * @return отрадактированного расширения
     */
    @Transactional
    public Long editFileExtension(FileExtensionAddRequest request){
        var fileExtension = repository.getReferenceById(request.getId());
        merger.merge(fileExtension, request);
        return repository.save(fileExtension).getId();
    }

    /**
     * Удаление расширения по id
     * @param id расширения
     */
    @Transactional
    public void deleteFileExtension(Long id){
        repository.deleteById(id);
    }
}
