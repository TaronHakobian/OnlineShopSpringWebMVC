package com.shop.database;

import com.shop.enums.PostCategory;
import com.shop.models.Post;
import com.shop.models.User;

import java.util.ArrayList;
import java.util.List;

public class DB {
    public static final List<Post> posts;
    public static final List<User> users;

    static {
        posts = new ArrayList<>();
        users = new ArrayList<>();
        users.add(new User("Taron", "123"));
        users.add(new User("Davit", "Hakobyan", "Davit", "taronhakobyan033@gmail.com", "123"));

    }

    public static boolean containsUserWithUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsUserWithEmail(String email) {
        for (User u : users) {
            if (u.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static User getByUsernameAndPassword(String username, String password) {
        User user = new User(username, password);
        for (User u : users) {
            if (u.equalsByUsernameAndPassword(user)) {
                return u;
            }
        }
        return null;
    }

    public static Post getPostById(Integer id) {
        for (Post post : posts) {
            if (post.getPostId() == id) {
                return post;
            }
        }
        return null;
    }

    public static User getUserById(Integer id) {
        for (User user : users) {
            if (user.getUserId() == id) {
                return user;
            }
        }
        return null;
    }

    public static ArrayList<Post> getPostsByLargeCategory(String category) {
        ArrayList<Post> newPosts = new ArrayList<>();
        switch (category) {
            case "Accessories" -> {
                for (Post post : posts) {
                    if (post.getCategory().equals("Jewellery") ||
                            post.getCategory().equals("Watches")) {
                        newPosts.add(post);
                    }
                }
                return newPosts;
            }
            case "Jobs" -> {
                for (Post post : posts) {
                    if (post.getCategory().equals("ProgrammingAndDevelopment") ||
                            post.getCategory().equals("ScienceAndEngineering") ||
                            post.getCategory().equals("MediaAndDesign")) {
                        newPosts.add(post);
                    }
                }
                return newPosts;
            }
            case "Vehicle" -> {
                for (Post post : posts) {
                    if (post.getCategory().equals("Car") ||
                            post.getCategory().equals("Bike") ||
                            post.getCategory().equals("Bus")) {
                        newPosts.add(post);
                    }
                }
                return newPosts;
            }
            case "Cloths" -> {
                for (Post post : posts) {
                    if (post.getCategory().equals("Shoes") ||
                            post.getCategory().equals("Clothing") ||
                            post.getCategory().equals("Underwear")) {
                        newPosts.add(post);
                    }
                }
                return newPosts;
            }
        }
        return newPosts;
    }

}
