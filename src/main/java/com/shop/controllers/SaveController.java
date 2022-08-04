package com.shop.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/saved")
public class SaveController {

    @GetMapping
    public ModelAndView getSavedPage(@RequestParam("favorite") String favorite, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("saved");
        modelAndView.addObject("want", favorite);
        return new ModelAndView();
    }
}
