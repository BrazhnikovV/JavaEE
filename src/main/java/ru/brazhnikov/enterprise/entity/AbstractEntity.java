package ru.brazhnikov.enterprise.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @Nullable
    protected String id = UUID.randomUUID().toString();
}
