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
 * ProductEditServlet - сервлет
 *
 * @version 1.0.1
 * @package ru.brazhnikov.enterprise.sevlet.category
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
@WebServlet( urlPatterns = "/product-edit")
public class ProductEditServlet extends HttpServlet {

    /**
     * @access private
     * CategoryRepository categoryRepository -
     */
    @Inject
    private ProductRepositoryBean productRepositoryBean;

    /**
     * @access private
     * String title - титульный заголовок
     */
    private final static String title = "Редактировать товар";

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {

        final String productId = req.getParameter( FieldConf.ID );
        final Product product = this.productRepositoryBean.findById( productId );

        if ( product == null ) {
            resp.sendError( HttpServletResponse.SC_NOT_FOUND );
            return;
        }

        req.setAttribute( FieldConf.PRODUCT, product );
        req.setAttribute( "title", title );

        req.getRequestDispatcher( "/WEB-INF/views/product/product-edit.jsp" ).forward( req, resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
