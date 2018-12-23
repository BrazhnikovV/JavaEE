package ru.brazhnikov.enterprise.sevlet.error;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ErrorServlet - сервлет для работы со страницей ошибка
 *
 * @version 1.0.1
 * @package ru.brazhnikov.enterprise.sevlet.error
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
@WebServlet( urlPatterns = "/error")
public class ErrorServlet  extends HttpServlet {

    /**
     * @access private
     * String title - титульный заголовок
     */
    private final static String title = "Ошибка №404";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendError( 404, "Error №404" );
    }
}
