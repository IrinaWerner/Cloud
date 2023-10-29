package ru.mycloud.cloud.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.mycloud.cloud.entity.BaseEntity;
import ru.mycloud.cloud.entity.role.Role;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "USER_ROLE")
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "USER_ROLE_ID"))


public class UserRole extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    public UserRole(Long userRoleId ) {
        this.id = userRoleId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    @Override
    public UserRole setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public UserRole setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public UserRole setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }




}
