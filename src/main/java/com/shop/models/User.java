package com.shop.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Component("user")
public class User {
    private static int incremented = 1;
    private Integer userId = incremented++;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private List<Post> posts;
    private List<Post> favoritePosts;
    private List<User> favoriteUsers;
    private Theme theme = Theme.Light;


    public static enum Theme {
        Dark, Light
    }

    public User(){

    }

    public User(String firstname, String lastname, String username, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = new ArrayList<>();
        this.favoritePosts= new ArrayList<>();
        this.favoriteUsers = new ArrayList<>();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.posts = new ArrayList<>();
        this.favoritePosts = new ArrayList<>();
        this.favoriteUsers = new ArrayList<>();
    }

    public String getTheme() {
        if (theme == Theme.Light) {
            return "white";
        } else {
            return "darkslategray";
        }
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getFavoritePosts() {
        return favoritePosts;
    }

    public void setFavoritePosts(List<Post> favoritePosts) {
        this.favoritePosts = favoritePosts;
    }

    public List<User> getFavoriteUsers() {
        return favoriteUsers;
    }

    public void setFavoriteUsers(List<User> favoriteUsers) {
        this.favoriteUsers = favoriteUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return firstname.equals(user.firstname) && lastname.equals(user.lastname) && username.equals(user.username) && email.equals(user.email) && password.equals(user.password);
    }

    public boolean equalsByUsernameAndPassword(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, username, email, password, theme);
    }
}
