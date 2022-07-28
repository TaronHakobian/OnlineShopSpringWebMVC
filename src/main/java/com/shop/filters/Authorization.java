package com.shop.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

//TODO investigate
@Component("authorization")
public class Authorization implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println();
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
