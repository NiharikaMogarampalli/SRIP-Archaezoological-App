package com.example.archaezooapp;

public class RVModel {

    private int edit;
    private String text;
    private int download;

    public int getEdit() {
        return edit;
    }

    public String getText() {
        return text;
    }

    public int getDownload() {
        return download;
    }

    public RVModel(int edit, String text, int download) {
        this.edit = edit;
        this.text = text;
        this.download = download;
    }
}
