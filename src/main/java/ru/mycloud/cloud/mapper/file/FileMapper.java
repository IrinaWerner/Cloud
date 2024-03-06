package ru.mycloud.cloud.mapper.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.file.FileAddRequest;
import ru.mycloud.cloud.entity.file.File;
import ru.mycloud.cloud.entity.file.Folder;
import ru.mycloud.cloud.mapper.Mapper;

@RequiredArgsConstructor
@Service
public class FileMapper implements Mapper<File, FileAddRequest> {

    @Override
    public File from(FileAddRequest source) {
        return new File()
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setFolder(new Folder(source.getFolderId()));
    }

}
