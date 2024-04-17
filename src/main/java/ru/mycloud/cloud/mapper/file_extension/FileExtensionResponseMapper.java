package ru.mycloud.cloud.mapper.file_extension;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ru.mycloud.cloud.dto.response.file_extension.FileExtensionResponse;
import ru.mycloud.cloud.entity.file.FileExtension;
import ru.mycloud.cloud.mapper.Mapper;

@RequiredArgsConstructor
@Service
public class FileExtensionResponseMapper implements Mapper<FileExtensionResponse, FileExtension> {

    @Override
    public FileExtensionResponse from(FileExtension source) {
        return new FileExtensionResponse()
                .setId(source.getId())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreated(source.getCreated())
                .setModified(source.getModified());

    }
}
