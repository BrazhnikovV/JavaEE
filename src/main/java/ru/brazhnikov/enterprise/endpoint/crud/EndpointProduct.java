package ru.brazhnikov.enterprise.endpoint.crud;

import org.jetbrains.annotations.NotNull;
import ru.brazhnikov.enterprise.entity.Category;
import ru.brazhnikov.enterprise.repository.database.CategoryRepositoryBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@WebService
@Path( "/categories" )
@ApplicationScoped
public class EndpointProduct {

    /**
     * @access private
     * CategoryRepository categoryRepository -
     */
    @Inject
    private CategoryRepositoryBean categoryRepositoryBean;

    @GET
    @NotNull
    @WebMethod
    @Produces( MediaType.APPLICATION_JSON )
    public List<Category> getCategoryList () {
        return null;
    }
}
