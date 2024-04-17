package ru.mycloud.cloud.mapper.file_extension;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.file_extension.FileExtensionAddRequest;

import ru.mycloud.cloud.entity.file.FileExtension;

import ru.mycloud.cloud.mapper.Mapper;

@RequiredArgsConstructor
@Service
public class FileExtensionMapper implements Mapper<FileExtension, FileExtensionAddRequest> {
    @Override
    public FileExtension from(FileExtensionAddRequest source) {
        return new FileExtension()
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
