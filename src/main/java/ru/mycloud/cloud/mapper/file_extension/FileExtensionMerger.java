package ru.mycloud.cloud.mapper.file_extension;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ru.mycloud.cloud.dto.request.file_extension.FileExtensionAddRequest;

import ru.mycloud.cloud.entity.file.FileExtension;

import ru.mycloud.cloud.mapper.Merger;

@RequiredArgsConstructor
@Service
public class FileExtensionMerger implements Merger<FileExtension, FileExtensionAddRequest> {

    @Override
    public FileExtension merge(FileExtension target, FileExtensionAddRequest source) {
        return target.setName(source.getName())
                .setDescription(source.getDescription());
    }
}
