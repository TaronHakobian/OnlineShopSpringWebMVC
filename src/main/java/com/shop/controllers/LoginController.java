package com.shop.controllers;

import com.shop.models.User;
import com.shop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    //TODO login redirect to home crashes

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
        User user = loginService.login(requestParams, redirectAttributes);
        session.setAttribute("user", user);
        if (user == null) {
            RedirectView view = new RedirectView("login");
            view.setAttributesMap(redirectAttributes.asMap());
            return view;
        }
        return new RedirectView("home");
    }
}


