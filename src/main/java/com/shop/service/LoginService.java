package com.shop.service;

import com.shop.database.DB;
import com.shop.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Service
public class LoginService {

    public User login(Map<String, String> requestParams, RedirectAttributes redirectAttributes) {
        User user = null;
        try {
            user = paramsValidation(requestParams);
        } catch (IllegalArgumentException e) {
            redirectAttributes.addAttribute("msg", e.getMessage());
        }
        return user;
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
