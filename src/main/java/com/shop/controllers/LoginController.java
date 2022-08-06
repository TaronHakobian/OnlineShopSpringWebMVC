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

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getLogin() {
        return new ModelAndView("login");
    }

    @RequestMapping(method = RequestMethod.POST)
    public RedirectView redirectAfterPost(@RequestParam Map<String, String> requestParams,
                                          HttpSession session,
                                          RedirectAttributes redirectAttributes) {
        try {
            User user = loginService.login(requestParams);
            session.setAttribute("user", user);
            return new RedirectView("home");
        } catch (IllegalArgumentException e) {
            RedirectView view = new RedirectView("login");
            redirectAttributes.addAttribute("msg", e.getMessage());
            view.setAttributesMap(redirectAttributes.asMap());
            return view;
        }
    }
}


