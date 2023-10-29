package ru.mycloud.cloud.entity.file;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.mycloud.cloud.entity.EntityWithName;
import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "FILE_EXTENSION")
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "FILE_EXTENSION_ID"))

public class FileExtension extends EntityWithName {

    @Serial
    private static final long serialVersionUID = 1L;

    public FileExtension(Long id) {
        this.id = id;
    }

    @Override
    public FileExtension setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public FileExtension setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public FileExtension setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }


    @Override
    public FileExtension setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public FileExtension setName(String name) {
        this.name = name;
        return this;
    }
}
