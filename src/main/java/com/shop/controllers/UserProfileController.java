package com.shop.controllers;

import com.shop.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserProfileController {

    @GetMapping("/userprofile")
    public ModelAndView getUserprofile() {
        return new ModelAndView("userprofile");
    }

    @RequestMapping(method = RequestMethod.POST)
    public RedirectView redirectTo(@RequestParam Map<String, String> requestParams, HttpSession session) {
        if (requestParams.get("logout") != null) {
            session.removeAttribute("user");
            return new RedirectView("home");
        } else if (requestParams.get("addpost") != null) {

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
}
