package ru.brazhnikov.enterprise.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;
import ru.brazhnikov.enterprise.entity.Category;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
public final class CategoryDTO {

    @Nullable
    private String id;

    @Nullable
    private String name;

    @Nullable
    private String description;

    @Nullable
    private String created;

    /**
     * CategoryDTO - конструктор
     * @param category - объект категории товара
     */
    public CategoryDTO ( @Nullable final Category category ) {
        if ( category == null ) {
            return;
        }

        this.id = category.getId();
        this.name = category.getName();
        this.description = category.getDescription();
        this.created = category.getCreated();
    }
}
