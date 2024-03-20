package ru.mycloud.cloud.dto.request.folder;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FolderAddRequest {
    private Long folderId;
    private Long folderParentId;
    private String name;
    private String description;
}
