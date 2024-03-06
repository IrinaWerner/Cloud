package ru.mycloud.cloud.mapper.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.response.file.FileResponse;
import ru.mycloud.cloud.entity.file.File;
import ru.mycloud.cloud.mapper.Mapper;

@RequiredArgsConstructor
@Service
public class FileResponseMapper implements Mapper<FileResponse, File> {
    @Override
    public FileResponse from(File source) {
        return new FileResponse()
                .setFileId(source.getId())
                .setFolderId(source.getFolder().getId())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setSize(source.getSize())
                .setFileExtension(source.getFileExtension().getName())
                .setCreated(source.getCreated())
                .setModified(source.getModified());

    }
}
