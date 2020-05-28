package com.example.karorok.zamtest;

import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("20")
    private Number n20;

    @SerializedName("21")
    private Number n21;

    @SerializedName("22")
    private Number n22;

    @SerializedName("23")
    private Number n23;

    @SerializedName("24")
    private Number n24;

    @SerializedName("25")
    private Number n25;

    @SerializedName("26")
    private Number n26;

    @SerializedName("27")
    private Number n27;

    @SerializedName("28")
    private Number n28;

    @SerializedName("29")
    private Number n29;

    @SerializedName("30")
    private Number n30;

    public Number getNumber(int index){
        if(index == 0){
            return n20;
        }else if(index == 1){
            return n21;
        }else if(index == 2){
            return n22;
        }else if(index == 3){
            return n23;
        }else if(index == 4){
            return n24;
        }else if(index == 5){
            return n25;
        }else if(index == 6){
            return n26;
        }else if(index == 7){
            return n27;
        }else if(index == 8){
            return n28;
        }else if(index == 9){
            return n29;
        }else {
            return n30;
        }
    }

}
