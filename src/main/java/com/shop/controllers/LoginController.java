package com.shop.controllers;

import com.shop.models.User;
import com.shop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
@RequestMapping(value = "/login")
@SessionAttributes("user")
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

    //TODO attributes dont show themselves
    @RequestMapping(method = RequestMethod.POST)
    public RedirectView redirectAfterPost(@RequestParam Map<String, String> requestParams, RedirectAttributes redirectAttributes) {
        return loginService.login(requestParams, redirectAttributes);
    }

    @ModelAttribute("user")
    public User createUser() {
        return new User();
    }
}


