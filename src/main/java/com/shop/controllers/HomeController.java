package com.shop.controllers;

import com.shop.database.DB;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/home")
public class HomeController {


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("posts", DB.posts);
        return modelAndView;
    }

}
