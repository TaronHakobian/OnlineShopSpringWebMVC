package com.shop.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//TODO investigate
@Component("authorization")
public class Authorization implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String url = ((HttpServletRequest) request).getRequestURL().toString();
        System.out.println(url);
        System.out.println(url);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
