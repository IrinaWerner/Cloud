package ru.mycloud.cloud.mapper.folder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mycloud.cloud.dto.request.folder.FolderAddRequest;
import ru.mycloud.cloud.entity.file.Folder;
import ru.mycloud.cloud.mapper.Merger;

@Service
@RequiredArgsConstructor
public class FolderMerger implements Merger<Folder, FolderAddRequest> {

    @Override
    public Folder merge(Folder target, FolderAddRequest source) {
        return target.setName(source.getName())
                .setDescription(source.getDescription())
                .setParentFolder(new Folder(source.getFolderParentId()));
    }
}
