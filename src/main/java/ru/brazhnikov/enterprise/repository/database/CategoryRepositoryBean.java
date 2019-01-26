package ru.brazhnikov.enterprise.repository.database;

import javax.ejb.Stateless;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.brazhnikov.enterprise.entity.Category;
import ru.brazhnikov.enterprise.repository.AbstractRepository;

@Stateless
public class CategoryRepositoryBean extends AbstractRepository {

    @NotNull
    public Collection<Category> findAll() {
        return this.em.createQuery( "SELECT e FROM Category e ORDER BY  e.created DESC", Category.class ).getResultList();
    }

    @Nullable
    public Category findById(@Nullable String id) {
        return this.em.find( Category.class, id );
    }

    @Nullable
    public Category getById(@Nullable final String categoryId) {
        if ( categoryId == null || categoryId.isEmpty() ) {
            return null;
        }

        return (Category) this.em.createQuery( "SELECT e FROM Category e WHERE e.id = :id", Category.class )
                .setParameter( "id", categoryId )
                .setMaxResults(1);
    }

    @Nullable
    public Category persist(@Nullable final Category category) {
        if ( category == null ) {
            this.em.persist( category );
        }

        return category;
    }

    @Nullable
    public Category merge(@Nullable final Category category) {
        if ( category == null ) {
            return null;
        }

        return this.em.merge( category );
    }

    public void removeById(@Nullable final String categoryId) {
        @Nullable final Category category = this.getById( categoryId );
        if ( category == null ) {
            return;
        }
        this.em.remove( category );
    }

    public void removeCategory(@Nullable Category category) {
        this.em.remove( category );
    }

    public void removeAll() {
        this.em.createQuery( "DELETE FROM Category " ).executeUpdate();
    }
}
