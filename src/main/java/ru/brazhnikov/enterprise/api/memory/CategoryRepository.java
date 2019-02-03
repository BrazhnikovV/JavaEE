package ru.brazhnikov.enterprise.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.brazhnikov.enterprise.entity.Category;

import java.util.Collection;

public interface CategoryRepository {

    @NotNull
    Collection<Category> findAll();

    @Nullable
    Category findById( @Nullable final String id );

    @NotNull
    Collection<Category> findByIds( @Nullable final Collection<String> ids );

    @Nullable
    Category merge ( @Nullable final Category category );

    @Nullable
    Collection<Category> merge ( @Nullable final Collection<Category> categories );

    void removeById( @Nullable final String id);

    void removeByIds( @Nullable final Collection<String> ids );

    void remove ( @Nullable final Collection<Category> categories );

    void removeAll();
}
