package ru.brazhnikov.enterprise.sevlet.category;

import ru.brazhnikov.enterprise.config.FieldConf;
import ru.brazhnikov.enterprise.repository.database.CategoryRepositoryBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CategoryDeleteServlet - сервлет
 *
 * @version 1.0.1
 * @package ru.brazhnikov.enterprise.sevlet.category
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
@WebServlet( urlPatterns = "/category-delete")
public class CategoryDeleteServlet extends HttpServlet {

    /**
     * @access private
     * CategoryRepository categoryRepository -
     */
    @Inject
    private CategoryRepositoryBean categoryRepositoryBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String categoryId = req.getParameter( FieldConf.ID );
        this.categoryRepositoryBean.removeById( categoryId );
        resp.sendRedirect( "category-list" );
    }
}
