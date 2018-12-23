package ru.brazhnikov.enterprise.sevlet.dispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * IndexServlet - сервлет для работы с расширениями серверных файлов
 *
 * @version 1.0.1
 * @package ru.brazhnikov.enterprise.sevlet.dispatcher
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
@WebServlet( urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.html" ).forward( req, resp );
    }
}
