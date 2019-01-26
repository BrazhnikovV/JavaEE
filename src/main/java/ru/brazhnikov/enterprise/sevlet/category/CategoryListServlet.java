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
 * CategoryListServlet - сервлет
 *
 * @version 1.0.1
 * @package ru.brazhnikov.enterprise.sevlet.category
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
@WebServlet( urlPatterns = "/category-list")
public class CategoryListServlet extends HttpServlet {

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
    private final static String title = "Список категорий";

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {

        final Collection<Category> categories = this.categoryRepositoryBean.findAll();
        req.setAttribute( "title", title );
        req.setAttribute( FieldConf.CATEGORIES, categories );
        req.getRequestDispatcher( "/WEB-INF/views/category/category-list.jsp" ).forward( req, resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
