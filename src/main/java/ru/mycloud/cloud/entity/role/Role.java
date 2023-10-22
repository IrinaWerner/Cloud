package ru.mycloud.cloud.entity.role;

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

@Entity(name = "ROLE")
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "ROLE_ID"))
public class Role extends EntityWithName {

    @Serial
    private static final long serialVersionUID = 1L;

    public Role(Long roleId) {
        this.id = roleId;
    }

    @Override
    public Role setId(Long id) {
       this.id = id;
       return this;
    }

    @Override
    public Role setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public Role setModified(LocalDateTime modified) {
       this.modified = modified;
        return this;
    }


    @Override
    public Role setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public Role setName(String name) {
       this.name = name;
        return this;
    }


}
