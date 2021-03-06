package ru.brazhnikov.enterprise.sevlet.product;

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
 * ProductCreateServlet - сервлет
 *
 * @version 1.0.1
 * @package ru.brazhnikov.enterprise.sevlet.product
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
@WebServlet( urlPatterns = "/product-create")
public class ProductCreateServlet extends HttpServlet {

    /**
     * @access private
     * CategoryRepository categoryRepository -
     */
    @Inject
    private ProductRepositoryBean productRepositoryBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Product product = new Product( "" + System.currentTimeMillis() );
        this.productRepositoryBean.merge( product );
        resp.sendRedirect( "product-list" );
    }
}
