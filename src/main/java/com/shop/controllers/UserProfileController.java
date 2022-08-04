package com.shop.controllers;

import com.shop.database.DB;
import com.shop.models.Post;
import com.shop.models.User;
import com.shop.service.AddPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/userprofile")
public class UserProfileController {

    private final AddPostService addPostService;

    @Autowired
    public UserProfileController(AddPostService addPostService) {
        this.addPostService = addPostService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getUserprofile() {
        return new ModelAndView("userprofile");
    }

    @RequestMapping(method = RequestMethod.POST)
    public RedirectView redirectTo(@RequestParam Map<String,
            String> requestParams, HttpSession session, RedirectAttributes redirectAttributes) {
        if (requestParams.get("logout") != null) {
            session.removeAttribute("user");
            return new RedirectView("/home");
        } else if (requestParams.get("addpost") != null) {
            return new RedirectView("/addPost");
        } else if (requestParams.get("light") != null) {
            User user = (User) session.getAttribute("user");
            user.setTheme(User.Theme.Light);
        } else if (requestParams.get("dark") != null) {
            User user = (User) session.getAttribute("user");
            user.setTheme(User.Theme.Dark);
            return new RedirectView("userprofile");
        }
        return null;
    }

    @PostMapping("savePost")
    public RedirectView savePost(@RequestParam("postId") Integer postId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        user.getFavoritePosts().add(DB.getPostById(postId));
        return new RedirectView("/userprofile");
    }


    @PostMapping("saveUser")
    public RedirectView saveUser(@RequestParam("userId") Integer userId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        user.getFavoriteUsers().add(DB.getUserById(userId));
        return new RedirectView("/userprofile");
    }

}
