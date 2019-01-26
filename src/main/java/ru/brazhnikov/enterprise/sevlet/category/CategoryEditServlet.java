package ru.brazhnikov.enterprise.sevlet.category;

import ru.brazhnikov.enterprise.config.FieldConf;
import ru.brazhnikov.enterprise.entity.Category;
import ru.brazhnikov.enterprise.repository.database.CategoryRepositoryBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * CategoryEditServlet - сервлет
 *
 * @version 1.0.1
 * @package ru.brazhnikov.enterprise.sevlet.category
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
@WebServlet( urlPatterns = "/category-edit")
public class CategoryEditServlet extends HttpServlet {

    /**
     * @access private
     * CategoryRepository categoryRepository -
     */
    @Inject
    private CategoryRepositoryBean categoryRepositoryBean;

    /**
     * @access private
     * String title - титульный заголовок
     */
    private final static String title = "Редактировать категорию";

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {

        final String categoryId = req.getParameter( FieldConf.ID );
        final Category category = categoryRepositoryBean.findById( categoryId );

        if ( category == null ) {
            resp.sendError( HttpServletResponse.SC_NOT_FOUND );
            return;
        }

        req.setAttribute( FieldConf.CATEGORY, category );
        req.setAttribute( "title", title );

        req.getRequestDispatcher( "/WEB-INF/views/category/category-edit.jsp" ).forward( req, resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
