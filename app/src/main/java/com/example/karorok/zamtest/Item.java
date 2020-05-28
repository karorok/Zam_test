package com.example.karorok.zamtest;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("width")
    private int width;


    @SerializedName("text")
    private String text;

    @SerializedName("color")
    private String color;

    public int getWidth() {
        return width;
    }

    public String getText() {
        return text;
    }

    public String getColor() {
        return color;
    }
}
