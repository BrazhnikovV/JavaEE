package ru.brazhnikov.enterprise.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.brazhnikov.enterprise.api.ProductRepository;
import ru.brazhnikov.enterprise.entity.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class ProductRepositoryBean implements ProductRepository {

    private Map<String, Product> products = new LinkedHashMap<>();

    @PostConstruct
    private void init () {
        this.merge( new Product( "english-premier-league" ) );
    }

    @NotNull
    @Override
    public Collection<Product> findAll() {
        return this.products.values();
    }

    @Nullable
    @Override
    public Product findById( @Nullable final String id ) {

        if ( id == null || id.isEmpty() ) {
            return null;
        }

        return this.products.get( id );
    }

    @NotNull
    @Override
    public Collection<Product> findByIds( @Nullable final Collection<String> ids ) {

        if ( ids == null || ids.isEmpty() ) {
            return Collections.emptySet();
        }

        @NotNull final Collection<Product> result = new LinkedHashSet<>();
        for ( @Nullable final String id: ids ) {
            if ( id == null || id.isEmpty() ) {
                continue;
            }

            final Product product = this.findById( id );
            if ( product == null ) {
                continue;
            }

            result.add( product );
        }

        return result;
    }

    @Nullable
    @Override
    public Product merge( @Nullable final Product product ) {

        if ( product == null ) {
            return null;
        }

        @Nullable final String id = product.getId();
        if ( id == null || id.isEmpty() ) {
            return null;
        }

        this.products.put( id, product );

        return product;
    }

    @Nullable
    @Override
    public Collection<Product> merge( @Nullable final Collection<Product> products ) {

        if ( products == null || products.isEmpty() ) {
            return Collections.emptySet();
        }

        @NotNull final Collection<Product> result = new LinkedHashSet<>();
        for ( @Nullable final Product product : products ) {
            if ( product == null ) {
                continue;
            }
            result.add( this.merge( product ) );
        }

        return result;
    }

    @Override
    public void removeById( @Nullable final String id ) {

        if ( id == null || id.isEmpty() ) {
            return;
        }

        if ( !this.products.containsKey( id ) ) {
            return;
        }

        this.products.remove( id );
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
    public void remove( @Nullable final Collection<Product> products ) {

        if ( products == null || products.isEmpty() ) {
            return;
        }

        for ( @Nullable Product product : products ) {
            if ( product == null ) {
                continue;
            }

            this.removeById( product.getId() );
        }
    }

    @Override
    public void removeAll() {
        this.products.clear();
    }
}
