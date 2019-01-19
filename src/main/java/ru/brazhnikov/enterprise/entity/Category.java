package ru.brazhnikov.enterprise.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@NoArgsConstructor
public class Category extends AbstractEntity {

    @Nullable
    private String name = "";

    @Nullable
    private String description = "";

    public Category( @Nullable final String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }
}
