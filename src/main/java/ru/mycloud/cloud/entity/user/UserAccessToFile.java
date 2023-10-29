package ru.mycloud.cloud.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.mycloud.cloud.entity.BaseEntity;
import ru.mycloud.cloud.entity.file.File;
import ru.mycloud.cloud.entity.file.TypeOfFileAccess;
import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "USER_ACCESS_TO_FILE")
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "USER_ACCESS_TO_FILE_ID"))

public class UserAccessToFile extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_ID")
    private File file;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPE_OF_FILE_ACCESS_ID")
    private TypeOfFileAccess typeOfFileAccess;

    public UserAccessToFile(Long id ) {
        this.id = id;
    }

    @Override
    public UserAccessToFile setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public UserAccessToFile setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public UserAccessToFile setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }
}
