package com.sabakieng.managerspecialslist;


public class Purchase {
    public String display_name;
    public String height;
    public String width;
    public String original_price;
    public String imageUrl;
    public String price;


    @Override
    public String toString() { return " " + display_name + " " + height + " " + price; }// still incomplete.
}
