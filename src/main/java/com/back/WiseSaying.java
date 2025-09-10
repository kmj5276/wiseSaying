package com.back;

public class WiseSaying {
    private int id;
    private String saying;
    private String author;

    public WiseSaying(int id, String saying, String author) {
        this.id = id;
        this.saying = saying;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaying() {
        return saying;
    }

    public void setSaying(String saying) {
        this.saying = saying;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
