package ru.brazhnikov.enterprise.sevlet.annotation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CatalogServlet - сервлет для работы с каталогом
 *
 * @version 1.0.1
 * @package ru.brazhnikov.enterprise.sevlet.annotation
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
@WebServlet( urlPatterns = "/main")
public class CatalogServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("CatalogServlet => страница каталога");
    }
}