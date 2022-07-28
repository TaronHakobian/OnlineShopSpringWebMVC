package com.shop.filters;

import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component("filter")
public class AuthenticationFilter implements Filter {

    private final UserService userService;

    @Autowired
    public AuthenticationFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //TODO logic???
//        userService.userAuthentication();
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
