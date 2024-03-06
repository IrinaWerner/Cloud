package ru.mycloud.cloud.dto.response.file;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class FileResponse {
    private Long fileId;
    private Long folderId;
    private String name;
    private String description;
    private Long size;
    private String fileExtension;
    private LocalDateTime created;
    private LocalDateTime modified;
}
