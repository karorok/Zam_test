package com.example.karorok.zamtest;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Number {

    @SerializedName("items")
    private ArrayList<Item> items;

    public ArrayList<Item> getItems() {
        return items;
    }
}
