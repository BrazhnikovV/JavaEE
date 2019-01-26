package ru.brazhnikov.enterprise.sevlet.product;

import ru.brazhnikov.enterprise.config.FieldConf;
import ru.brazhnikov.enterprise.entity.Product;
import ru.brazhnikov.enterprise.repository.database.ProductRepositoryBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ProductSaveServlet - сервлет
 *
 * @version 1.0.1
 * @package ru.brazhnikov.enterprise.sevlet.category
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
@WebServlet( urlPatterns = "/product-save")
public class ProductSaveServlet extends HttpServlet {

    /**
     * @access private
     * CategoryRepository categoryRepository -
     */
    @Inject
    private ProductRepositoryBean productRepositoryBean;

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {

        final String id = req.getParameter( FieldConf.ID );
        if ( id == null || id.isEmpty() ) {
            this.sendRedirectCategoryList( resp );
            return;
        }

        final Product product = this.productRepositoryBean.findById( id );
        if ( product == null ) {
            this.sendRedirectCategoryList( resp );
        }

        product.setName( req.getParameter( FieldConf.NAME ));
        product.setDescription( req.getParameter( FieldConf.DESCRIPTION ));
        this.productRepositoryBean.merge( product );
        this.sendRedirectCategoryList( resp );
    }

    /**
     * sendRedirectCategoryList - сделать редирект
     * @param resp
     * @throws IOException
     */
    private void sendRedirectCategoryList(HttpServletResponse resp) throws IOException {
        resp.sendRedirect( "product-list" );
    }

    /**
     * sendRedirectCategoryList - сделать редирект
     * @param resp
     * @throws IOException
     */
    private void sendRedirectCategoryNotValid(HttpServletResponse resp) throws IOException {
        resp.sendRedirect( "product-edit-error" );
    }
}
