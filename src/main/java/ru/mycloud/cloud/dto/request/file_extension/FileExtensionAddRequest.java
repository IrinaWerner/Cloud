package ru.mycloud.cloud.dto.request.file_extension;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class FileExtensionAddRequest {
    private Long id;
    private String name;
    private String description;

}
