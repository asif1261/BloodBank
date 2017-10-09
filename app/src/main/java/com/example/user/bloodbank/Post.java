package com.example.user.bloodbank;

/**
 * Created by user on 12/13/2016.
 */

public class Post {
    private String postTitle;

    private String postSubTitle;
    private String postCity;
    private String postMobile;
    private int postImage;

    public String getPostCity() {
        return postCity;
    }

    public void setPostCity(String postCity) {
        this.postCity = postCity;
    }

    public String getPostMobile() {
        return postMobile;
    }

    public void setPostMobile(String postMobile) {
        this.postMobile = postMobile;
    }

    public int getPostImage() {
        return postImage;
    }

    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostSubTitle() {
        return postSubTitle;
    }

    public void setPostSubTitle(String postSubTitle) {
        this.postSubTitle = postSubTitle;
    }

    public Post(String postTitle, String postSubTitle, String postCity, String postMobile, int postImage) {
        this.postTitle = postTitle;
        this.postSubTitle = postSubTitle;
        this.postCity = postCity;
        this.postMobile = postMobile;
        this.postImage = postImage;
    }
}
