package com.example.user.bloodbank;

/**
 * Created by user on 11/28/2016.
 */

public class Data {
    public String title;
    public String description;
    public String mobile;
    public int imageId;
    public String city;

    Data(String title, String description, String city, String mobile , int imageId){
        this.title = title;
        this.description = description;
        this.city = city;
        this.mobile = mobile;
        this.imageId = imageId;

    }
}
