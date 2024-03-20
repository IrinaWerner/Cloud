package ru.mycloud.cloud.mapper.folder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.response.folder.FolderResponse;
import ru.mycloud.cloud.entity.file.Folder;
import ru.mycloud.cloud.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class FolderResponseMapper implements Mapper<FolderResponse, Folder> {

    @Override
    public FolderResponse from(Folder source) {
        return new FolderResponse()
                .setFolderId(source.getId())
                .setParentFolderId(source.getParentFolder().getId())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }


}
