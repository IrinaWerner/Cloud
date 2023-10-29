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

@Entity(name = "FOLDER")
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "FOLDER_ID"))


public class Folder extends EntityWithName {

    @Serial
    private static final long serialVersionUID = 1L;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_FOLDER_ID")
    private Folder parentFolder;


    public Folder(Long folderId ) {
        this.id = folderId;
    }

    @Override
    public Folder setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public Folder setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public Folder setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }



    @Override
    public Folder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Folder setDescription(String description) {
        this.description = description;
        return this;
    }
}
