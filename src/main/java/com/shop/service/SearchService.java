package com.shop.service;


import com.shop.database.DB;
import com.shop.enums.PostCategory;
import com.shop.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SearchService {


    public ArrayList<Post> getPostsByCategory(String category) {
        return DB.getPostsByLargeCategory(category);
    }

    public ArrayList<Post> getSearchResult(String searchContent) {
        ArrayList<Post> posts = new ArrayList<>();
        Pattern pattern = Pattern.compile(searchContent, Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        for (Post post : DB.posts) {
            matcher = pattern.matcher(post.getTitle());
            if (matcher.find()) {
                posts.add(post);
            }
        }
        return posts;
    }

    public ArrayList<Post> getPostsBySubSector(String subSector) {
        ArrayList<Post> posts = new ArrayList<>();
        for (Post post : DB.posts) {
            if (post.getCategory().equals(subSector)) {
                posts.add(post);
            }
        }
        return posts;
    }

}
