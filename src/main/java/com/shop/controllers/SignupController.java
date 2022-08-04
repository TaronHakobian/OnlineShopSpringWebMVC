package com.shop.controllers;

import com.shop.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
@RequestMapping(value = "/signup")
public class SignupController {

    private final SignupService signupService;

    @Autowired
    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getSignup() {
        return new ModelAndView("signup");
    }

    @RequestMapping(method = RequestMethod.POST)
    public RedirectView redirectAfterPost(@RequestParam Map<String, String> requestParams, RedirectAttributes redirectAttributes) {
        return signupService.signup(requestParams, redirectAttributes);
    }
}
