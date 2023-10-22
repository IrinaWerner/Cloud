package ru.mycloud.cloud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;

@Getter
@Setter
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@MappedSuperclass
public abstract class EntityWithName extends BaseEntity{

    @Serial
    private static final long serialVersionUID = 1L;

    @ToString.Include
    @Column(name = "NAME")
    protected String name;

    @ToString.Include
    @Column(name = "DESCRIPTION")
    protected String description;
}
