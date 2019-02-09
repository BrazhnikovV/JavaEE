package ru.brazhnikov.enterprise.repository.database;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.brazhnikov.enterprise.entity.Product;
import ru.brazhnikov.enterprise.repository.AbstractRepository;

import javax.ejb.Stateless;
import java.util.Collection;

@Stateless
public class ProductRepositoryBean extends AbstractRepository {

    @NotNull
    public Collection<Product> findAll() {
        return this.em.createQuery( "SELECT e FROM Product e ORDER BY  e.created DESC", Product.class ).getResultList();
    }

    @Nullable
    public Product findById(@Nullable String id) {
        return this.em.find( Product.class, id );
    }

    @Nullable
    public Product getById(@Nullable final String productId) {
        if ( productId == null || productId.isEmpty() ) {
            return null;
        }

        return (Product) this.em.createQuery( "SELECT e FROM Product e WHERE e.id = :id", Product.class )
                .setParameter( "id", productId )
                .setMaxResults(1);
    }

    @Nullable
    public Product persist(@Nullable final Product product) {
        if ( product == null ) {
            this.em.persist( product );
        }

        return product;
    }

    @Nullable
    public Product merge(@Nullable final Product product) {
        if ( product == null ) {
            return null;
        }

        return this.em.merge( product );
    }

    public void removeById(@Nullable final String productId) {
        @Nullable final Product product = this.getById( productId );
        if ( product == null ) {
            return;
        }
        this.em.remove( product );
    }

    public Product create() {
        return  new Product( "" );
    }

    public void removeCategory(@Nullable Product product) {
        this.em.remove( product );
    }

    public void removeAll() {
        this.em.createQuery( "DELETE FROM Product " ).executeUpdate();
    }
}
