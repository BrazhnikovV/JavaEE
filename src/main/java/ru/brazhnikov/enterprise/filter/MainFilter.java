package ru.brazhnikov.enterprise.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * MainFilter - сервлет для фильрации
 *
 * @version 1.0.1
 * @package ru.brazhnikov.enterprise.sevlet.filter
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class MainFilter implements Filter {

    private String encoding;

    @Override
    public void init( FilterConfig filterConfig ) throws ServletException {
        encoding = filterConfig.getInitParameter("requestEncoding" );
        if (encoding == null) encoding = "UTF-8";
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if ( null == servletRequest.getCharacterEncoding() ) {
            servletRequest.setCharacterEncoding( encoding );
        }

        // Set the default response content type and encoding
        servletResponse.setContentType( "text/html; charset=UTF-8" );
        servletResponse.setCharacterEncoding("UTF-8");

        filterChain.doFilter( servletRequest, servletResponse );
    }

    @Override
    public void destroy() {

    }
}
