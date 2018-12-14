package com.example.khizzipool.assignment3;

public class item {
    private  String mImageUrl;
    private  String mCreator;
    private  int mLikes;

    public item(String ImageUrl, String Creator, int Likes) {
        mImageUrl = ImageUrl;
        mCreator = Creator;
        mLikes = Likes;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmCreator() {
        return mCreator;
    }

    public int getmLikes() {
        return mLikes;
    }
}
