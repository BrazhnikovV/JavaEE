package ru.brazhnikov.enterprise.sevlet.annotation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ProductServlet - сервлет для работы со страницей продукта
 *
 * @version 1.0.1
 * @package ru.brazhnikov.enterprise.sevlet.annotation
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
@WebServlet( urlPatterns = "/product")
public class ProductServlet  extends HttpServlet {

    /**
     * @access private
     * String title - титульный заголовок
     */
    private final static String title = "продукт";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("CatalogServlet => страница продукта");
    }
}
