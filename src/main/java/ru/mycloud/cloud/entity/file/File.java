package ru.mycloud.cloud.entity.file;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.mycloud.cloud.entity.EntityWithName;


import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "FILE")
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "FILE_ID"))

public class File extends EntityWithName {

    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_EXTENSION_ID")
    private FileExtension fileExtension;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPE_OF_FILE_ACCESS_ID")
    private TypeOfFileAccess typeOfFileAccess;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOLDER_ID")
    private Folder folder;

    @Column(name = "SIZE")
    private Long size;

    public File(Long id) {
        this.id = id;
    }

    @Override
    public File setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public File setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public File setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }


    @Override
    public File setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public File setName(String name) {
        this.name = name;
        return this;
    }
}
