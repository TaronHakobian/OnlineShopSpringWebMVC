package com.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
@RequestMapping("/userprofile")
public class UserProfileController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getUserprofile () {
        return new ModelAndView("userprofile");
    }

    @RequestMapping(method = RequestMethod.POST)
    public RedirectView redirectTo(@RequestParam Map<String, String> requestParams) {
        System.out.println();
        return null;
    }
}
