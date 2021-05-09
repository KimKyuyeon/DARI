package com.google.ar.core.examples.java.helloar;

import java.util.ArrayList;


public class CommunityListData {
    private int comment_id;
    private int image_id;
    private String title;

    public CommunityListData(int _image_id, String _title, int _comment_id){
        this. image_id = _image_id;
        this.title = _title;
        this.comment_id = _comment_id;
    }

    public int getComment_id(){return comment_id;}
    public int getImage_id(){return image_id;}
    public String getTitle(){return title;}

    public void setComment_id(int comment_id) {this.comment_id = comment_id;}
    public void setImage_id(int image_id) {this.image_id = image_id;}
    public void setTitle(String title) {this.title = title;}
}
