package ru.brazhnikov.enterprise.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.brazhnikov.enterprise.entity.Product;
import java.util.Collection;

public interface ProductRepository {

    @NotNull
    Collection<Product> findAll();

    @Nullable
    Product findById(@Nullable final String id);

    @NotNull
    Collection<Product> findByIds(@Nullable final Collection<String> ids);

    @Nullable
    Product merge(@Nullable final Product product);

    @Nullable
    Collection<Product> merge(@Nullable final Collection<Product> categories);

    void removeById(@Nullable final String id);

    void removeByIds(@Nullable final Collection<String> ids);

    void remove(@Nullable final Collection<Product> categories);

    void removeAll();
}
