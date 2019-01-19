package ru.brazhnikov.enterprise.entity;


import lombok.Data;
import java.util.UUID;
import org.jetbrains.annotations.Nullable;

@Data
public class AbstractEntity {

    @Nullable
    protected String id = UUID.randomUUID().toString();
}
