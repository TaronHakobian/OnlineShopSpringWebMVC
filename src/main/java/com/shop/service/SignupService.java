package com.shop.service;

import com.shop.database.DB;
import com.shop.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SignupService {

    public RedirectView signup(Map<String, String> requestParams, RedirectAttributes redirectAttributes) {
        RedirectView redirectView;
        try {
            User user = paramsValidation(requestParams);
            DB.users.add(user);
            redirectView = new RedirectView("login");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("msg", e.getMessage());
            redirectView = new RedirectView("signup");
        }
        return redirectView;
    }

    private User paramsValidation(Map<String, String> requestParams) {
        Map<String, String> params = requestParams;
        String firstname = params.get("firstname");
        String lastname = params.get("lastname");
        String username = params.get("username");
        String email = params.get("email");
        String password = params.get("password");

        firstnameValidation(firstname);
        lastnameValidation(lastname);
        usernameValidation(username);
        emailValidation(email);
        passwordValidation(password);

        return new User(firstname, lastname, username, email, password);
    }

    private void firstnameValidation(String firstname) {
        if (firstname == null || !firstname.chars().allMatch(Character::isLetter)) {
            throw new IllegalArgumentException("inapplicable value for firstname");
        }
    }

    private void lastnameValidation(String lastname) {
        if (lastname == null || !lastname.chars().allMatch(Character::isLetter)) {
            throw new IllegalArgumentException("inapplicable value for firstname");
        }
    }

    private void usernameValidation(String username) {
        if (username == null || !username.chars().allMatch(Character::isLetter)) {
            throw new IllegalArgumentException("inapplicable value for firstname");
        } else if (DB.containsUserWithUsername(username)) {
            throw new IllegalArgumentException("username already exists");
        }
    }

    private void emailValidation(String email) {
        //TODO check if email is real
        if (DB.containsUserWithEmail(email)) {
            throw new IllegalArgumentException("User with this email already exists");
        }
    }

    private void passwordValidation(String password) {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("password validation failed");
        }
    }

}
