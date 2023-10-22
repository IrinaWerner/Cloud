package ru.mycloud.cloud.entity.user;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.mycloud.cloud.entity.BaseEntity;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "USERS")
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "USER_ID"))
public class User extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "USER_PASSWORD")
    private String password;

    @Column(name = "FULL_NAME")
    private String fullName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_STATUS_ID")
    private UserStatus status;

    public User(Long userId) {
        this.id = userId;
    }


    @Override
    public User setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public User setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public User setId(Long id) {
        this.id = id;
        return this;
    }
}
