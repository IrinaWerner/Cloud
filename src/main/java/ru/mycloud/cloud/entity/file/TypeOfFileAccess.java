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

@Entity(name = "TYPE_OF_FILE_ACCESS")
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "TYPE_OF_FILE_ACCESS_ID"))

public class TypeOfFileAccess extends EntityWithName {
    @Serial
    private static final long serialVersionUID = 1L;

    public TypeOfFileAccess(Long id) {
        this.id = id;
    }

    @Override
    public TypeOfFileAccess setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public TypeOfFileAccess setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public TypeOfFileAccess setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }


    @Override
    public TypeOfFileAccess setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public TypeOfFileAccess setName(String name) {
        this.name = name;
        return this;
    }
}
