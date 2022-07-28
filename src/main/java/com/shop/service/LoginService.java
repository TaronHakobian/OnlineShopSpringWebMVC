package com.shop.service;

import com.shop.database.DB;
import com.shop.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Service
public class LoginService {

    //TODO make "user" global attribute
    public RedirectView login(Map<String, String> requestParams, RedirectAttributes redirectAttributes) {
        User user;
        RedirectView redirectView;
        try {
            user = paramsValidation(requestParams);
            redirectView = new RedirectView("home");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("msg", e.getMessage());
            redirectView = new RedirectView("login");
        }
        return redirectView;
    }

    private User paramsValidation(Map<String, String> requestParams) {
        String username = requestParams.get("username");
        String password = requestParams.get("password");
        User user;
        try {
            usernameValidation(username);
            user = passwordValidation(username, password);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("username or password is incorrect");
        }
        return user;
    }

    private void usernameValidation(String username) {
        if (username == null || !DB.containsUserWithUsername(username)) {
            throw new IllegalArgumentException();
        }
    }

    private User passwordValidation(String username, String password) {
        User user = DB.getByUsernameAndPassword(username, password);
        if (user == null) {
            throw new IllegalArgumentException();
        }
        return user;
    }

}
