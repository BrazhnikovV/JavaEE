package ru.brazhnikov.enterprise.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Product extends AbstractEntity {

    @Nullable
    private String name;

    @Nullable
    private String description;

    @Nullable
    private String created = "";

    @ManyToOne
    private Category category;

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
