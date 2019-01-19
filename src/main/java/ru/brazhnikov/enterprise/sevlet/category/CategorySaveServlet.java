package ru.brazhnikov.enterprise.sevlet.category;

import ru.brazhnikov.enterprise.api.CategoryRepository;
import ru.brazhnikov.enterprise.config.FieldConf;
import ru.brazhnikov.enterprise.entity.Category;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CategorySaveServlet - сервлет
 *
 * @version 1.0.1
 * @package ru.brazhnikov.enterprise.sevlet.category
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
@WebServlet( urlPatterns = "/category-save")
public class CategorySaveServlet extends HttpServlet {

    /**
     * @access private
     * CategoryRepository categoryRepository -
     */
    @Inject
    private CategoryRepository categoryRepository;

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {

        final String id = req.getParameter( FieldConf.ID );
        if ( id == null || id.isEmpty() ) {
            this.sendRedirectCategoryList( resp );
            return;
        }

        final Category category = this.categoryRepository.findById( id );
        if ( category == null ) {
            this.sendRedirectCategoryList( resp );
        }

        category.setName( req.getParameter( FieldConf.NAME ));
        category.setDescription( req.getParameter( FieldConf.DESCRIPTION ));
        this.categoryRepository.merge( category );
        this.sendRedirectCategoryList( resp );
    }

    /**
     * sendRedirectCategoryList - сделать редирект
     * @param resp
     * @throws IOException
     */
    private void sendRedirectCategoryList(HttpServletResponse resp) throws IOException {
        resp.sendRedirect( "category-list" );
    }
}
