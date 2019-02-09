package ru.brazhnikov.enterprise.endpoint.crud;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.brazhnikov.enterprise.dto.ProductDTO;
import ru.brazhnikov.enterprise.entity.Product;
import ru.brazhnikov.enterprise.repository.database.ProductRepositoryBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@WebService
@Path( "/products" )
@ApplicationScoped
public class EndpointProduct {

    /**
     * @access private
     * CategoryRepository categoryRepository -
     */
    @Inject
    private ProductRepositoryBean productRepositoryBean;

    @GET
    @NotNull
    @WebMethod
    @Produces( MediaType.APPLICATION_JSON )
    public List<ProductDTO> getProductList () {
        return this.productRepositoryBean.findAll().stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @GET
    @NotNull
    @WebMethod
    @Path( "/create" )
    @Produces( MediaType.APPLICATION_JSON )
    public ProductDTO create () {
        final Product product = this.productRepositoryBean.create();
        return new ProductDTO( product );
    }

    @GET
    @NotNull
    @WebMethod
    @Path( "/getById" )
    @Produces( MediaType.APPLICATION_JSON )
    public ProductDTO getById (
            @QueryParam( "id" )
            @WebParam( name = "id", partName = "id")
            @Nullable final String id
    ) {
        final Product product = this.productRepositoryBean.getById( id );
        if ( product == null ) {
            return null;
        }
        return new ProductDTO( product );
    }

    /*
    @POST
    @Nullable
    @WebMethod
    @Path( "/merge" )
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public ProductDTO merge (@Nullable final ProductDTO product ) {
        return productRepositoryBean.merge( product );
    }
    */
}
