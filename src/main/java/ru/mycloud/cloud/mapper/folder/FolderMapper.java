package ru.mycloud.cloud.mapper.folder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.folder.FolderAddRequest;
import ru.mycloud.cloud.entity.file.Folder;
import ru.mycloud.cloud.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class FolderMapper implements Mapper<Folder, FolderAddRequest> {

    @Override
    public Folder from(FolderAddRequest source) {
        return new Folder()
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setParentFolder(new Folder(source.getFolderParentId()));
    }
}
