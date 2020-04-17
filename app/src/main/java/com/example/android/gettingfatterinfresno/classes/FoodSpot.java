package com.example.android.gettingfatterinfresno.classes;


public class FoodSpot {
    private String name;
    private String description;
    private String address;
    private String phone;
    private String website;
    private int imageId = -1;
    private String caption;

    public FoodSpot(String name, String description, String address, String phone, String website, int imageId, String caption) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.imageId = imageId;
        this.caption = caption;
    }
    public FoodSpot(String name, String description, String address, String phone, String website) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.website = website;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public int getImageId() {
        return imageId;
    }

    public String getCaption() {
        return caption;
    }
}
