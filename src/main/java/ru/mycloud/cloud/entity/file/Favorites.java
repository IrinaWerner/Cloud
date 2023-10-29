package ru.mycloud.cloud.entity.file;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.mycloud.cloud.entity.BaseEntity;
import ru.mycloud.cloud.entity.user.User;
import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "FAVORITES")
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "FAVORITES_ID"))

public class Favorites extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    // TODO Доделать ManyToOne для FILE_ID

    public Favorites(Long favoritesId ) {
        this.id = favoritesId;
    }

    @Override
    public Favorites setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public Favorites setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public Favorites setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }





}

