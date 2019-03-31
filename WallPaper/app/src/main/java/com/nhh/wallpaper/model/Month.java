package com.nhh.wallpaper.model;

import java.io.Serializable;

public class Month implements Serializable {
    private int imgMonth;
    private String monthName, author;

    public Month(int imgMonth, String monthName) {
        this.imgMonth = imgMonth;
        this.monthName = monthName;
        this.author = "Hoàng";
    }

    public Month() {
    }

    public int getImgMonth() {
        return imgMonth;
    }

    public void setImgMonth(int imgMonth) {
        this.imgMonth = imgMonth;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
