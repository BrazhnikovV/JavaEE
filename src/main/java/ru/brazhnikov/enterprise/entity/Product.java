package ru.brazhnikov.enterprise.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@NoArgsConstructor
public class Product extends AbstractEntity {

    @Nullable
    private Category category;

    @Nullable
    private String name;

    @Nullable
    private String description;

    public Product(@Nullable String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    @Nullable
    public String getName() {
        return name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }
}
