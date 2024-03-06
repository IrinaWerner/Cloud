package ru.mycloud.cloud.dto.request.file;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FileAddRequest {
    private Long fileId;
    private Long folderId;
    private String name;
    private String description;

}
