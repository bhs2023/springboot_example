package com.namgarambooks.myhome.filter;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;


import java.io.IOException;

@Component  //필터로 등록됨
public class MyCustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Request intercepted by custom filter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
