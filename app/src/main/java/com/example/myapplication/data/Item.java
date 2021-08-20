package com.example.myapplication.data;

import android.graphics.drawable.Drawable;

public class Item {
    private String title;
    private String price;
    private float rating; // 4.8
    private String number; // 9999+
    private Drawable image;

    public Item(String title, String price, float rating, String number, Drawable image) {
        this.title = title;
        this.price = price;
        this.rating = rating;
        this.number = number;
        this.image = image;
    }

    public String getTitle() {
        return this.title;
    }
    public String getPrice() {
        return this.price;
    }
    public float getRating() {
        return this.rating;
    }
    public String getNumber() {
        return this.number;
    }
    public Drawable getImage() {
        return this.image;
    }
}
