package ru.brazhnikov.enterprise.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import ru.brazhnikov.enterprise.entity.Product;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
public class ProductDTO {

    @Nullable
    private String id;

    @Nullable
    private String name;

    @Nullable
    private String description;

    @Nullable
    private String created;

    @Nullable
    private String categoryId;

    public ProductDTO ( @Nullable final Product product ) {
        if ( product == null ) {
            return;
        }

        this.id   = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.created     = product.getCreated();
        this.categoryId  = product.getCategory().getId();
    }
}
