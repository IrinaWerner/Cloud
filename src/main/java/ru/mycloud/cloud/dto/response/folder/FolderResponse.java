package ru.mycloud.cloud.dto.response.folder;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class FolderResponse {
    private Long folderId;
    private Long parentFolderId;
    private String name;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;


}
