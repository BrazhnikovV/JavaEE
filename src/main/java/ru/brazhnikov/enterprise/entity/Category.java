package ru.brazhnikov.enterprise.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category extends AbstractEntity {

    @Nullable
    private String name = "";

    @Nullable
    private String description = "";

    @Nullable
    private String created = "";

    @OneToMany( mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Product> products = new ArrayList<>();

    public Category( @Nullable final String name) {
        this.name = name;
    }

    @Nullable
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

    @Nullable
    public String getCreated() {
        return this.created;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }
}
