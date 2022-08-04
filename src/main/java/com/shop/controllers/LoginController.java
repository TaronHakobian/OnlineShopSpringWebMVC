package com.shop.controllers;

import com.shop.models.User;
import com.shop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@SessionAttributes("user")
@RequestMapping(value = "/login")
public class LoginController {

    private final LoginService loginService;
    private final ApplicationContext applicationContext;

    @Autowired
    public LoginController(LoginService loginService, ApplicationContext applicationContext) {
        this.loginService = loginService;
        this.applicationContext = applicationContext;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getLogin() {
        return new ModelAndView("login");
    }

    @RequestMapping(method = RequestMethod.POST)
    public RedirectView redirectAfterPost(@RequestParam Map<String, String> requestParams,
                                          HttpSession session,
                                          RedirectAttributes redirectAttributes) {
        User user = loginService.login(requestParams, redirectAttributes);
        if (user == null) {
            RedirectView view = new RedirectView("login");
            view.setAttributesMap(redirectAttributes.asMap());
            return view;
        }
        session.setAttribute("user", user);
        return new RedirectView("home");
    }
}


