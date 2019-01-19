package ru.brazhnikov.enterprise.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.brazhnikov.enterprise.api.CategoryRepository;
import ru.brazhnikov.enterprise.entity.Category;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class CategoryRepositoryBean implements CategoryRepository {

    /**
     * @access private
     * Map<String, Category> categories - мапа для хранения категорий
     */
    private Map<String, Category> categories = new LinkedHashMap<>();

    /**
     * init -
     */
    @PostConstruct
    private void init () {
        this.merge( new Category( "english-premier-league" ) );
    }

    @NotNull
    @Override
    public Collection<Category> findAll() {
        return this.categories.values();
    }

    @Nullable
    @Override
    public Category findById( @Nullable final String id ) {

        if ( id == null || id.isEmpty() ) {
            return null;
        }

        return this.categories.get( id );
    }

    @NotNull
    @Override
    public Collection<Category> findByIds( @Nullable final Collection<String> ids ) {

        if ( ids == null || ids.isEmpty() ) {
            return Collections.emptySet();
        }

        @NotNull final Collection<Category> result = new LinkedHashSet<>();
        for ( @Nullable final String id: ids ) {
            if ( id == null || id.isEmpty() ) {
                continue;
            }

            final Category category = this.findById( id );
            if ( category == null ) {
                continue;
            }

            result.add( category );
        }

        return result;
    }

    @Nullable
    @Override
    public Category merge( @Nullable final Category category ) {

        if ( category == null ) {
            return null;
        }

        @Nullable final String id = category.getId();
        if ( id == null || id.isEmpty() ) {
            return null;
        }

        this.categories.put( id, category );

        return category;
    }

    @Nullable
    @Override
    public Collection<Category> merge( @Nullable final Collection<Category> categories ) {

        if ( categories == null || categories.isEmpty() ) {
            return Collections.emptySet();
        }

        @NotNull final Collection<Category> result = new LinkedHashSet<>();
        for ( @Nullable final Category category : categories ) {
            if ( category == null ) {
                continue;
            }
            result.add( this.merge( category ) );
        }

        return result;
    }

    @Override
    public void removeById( @Nullable final String id ) {

        if ( id == null || id.isEmpty() ) {
            return;
        }

        if ( !this.categories.containsKey( id ) ) {
            return;
        }

        this.categories.remove( id );
    }

    @Override
    public void removeByIds( @Nullable final Collection<String> ids ) {

        if ( ids == null || ids.isEmpty() ) {
            return;
        }

        for ( @Nullable final String id: ids ) {
            this.removeById( id );
        }
    }

    @Override
    public void remove( @Nullable final Collection<Category> categories ) {

        if ( categories == null || categories.isEmpty() ) {
            return;
        }

        for ( @Nullable Category category : categories ) {
            if ( category == null ) {
                continue;
            }

            this.removeById( category.getId() );
        }
    }

    @Override
    public void removeAll() {
        this.categories.clear();
    }
}
