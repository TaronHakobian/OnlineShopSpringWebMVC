package com.shop.controllers;


import com.shop.models.User;
import com.shop.service.SavedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/saved")
public class SaveController {

    private final SavedService service;

    @Autowired
    public SaveController(SavedService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView getSavedPage(@RequestParam("favorite") String favorite, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("saved");
        User user = (User) session.getAttribute("user");
        if (favorite.equals("Posts")) {
            modelAndView.addObject("posts", user.getFavoritePosts());
        } else if (favorite.equals("Users")) {
            modelAndView.addObject("users", user.getFavoriteUsers());
        }
        return modelAndView;
    }
}
