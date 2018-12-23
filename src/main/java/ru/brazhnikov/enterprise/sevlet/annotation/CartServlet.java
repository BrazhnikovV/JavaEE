package ru.brazhnikov.enterprise.sevlet.annotation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CartServlet - сервлет для работы со страницей корзина
 *
 * @version 1.0.1
 * @package ru.brazhnikov.enterprise.sevlet.annotation
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
@WebServlet( urlPatterns = "/cart")
public class CartServlet  extends HttpServlet {

    /**
     * @access private
     * String title - титульный заголовок
     */
    private final static String title = "Корзина";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("OrderServlet => страница корзина");
    }
}

