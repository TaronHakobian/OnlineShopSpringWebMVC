package com.shop.models;


import org.springframework.stereotype.Component;

@Component("post")
public class Post {
    private static int incremented = 1;
    private Integer postId = incremented++;
    private Integer authorId;
    private String title;
    private String imageUrl;
    private String comment;
    private Enum category;

    public Post() {

    }

    public Post(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public Post(String title, String imageUrl, String comment, Enum category) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.comment = comment;
        this.category = category;
    }

    public Post(Integer authorId, String title, String imageUrl, String comment, Enum category) {
        this.authorId = authorId;
        this.title = title;
        this.imageUrl = imageUrl;
        this.comment = comment;
        this.category = category;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCategory() {
        return category.toString();
    }

    public void setCategory(Enum category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", comment='" + comment + '\'' +
                ", category=" + category +
                '}';
    }
}
