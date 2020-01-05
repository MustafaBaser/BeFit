package com.mustafabaser.befit;

public class ExampleItem {
    private int mImageResource;
    private String mText1;
    private String mText2;

    public ExampleItem(int imageresource, String text1, String text2){
        mImageResource = imageresource;
        mText1 = text1;
        mText2 = text2;
    }

    public int getmImageResource(){
        return mImageResource;
    }


    public String getText1(){
        return mText1;
    }

    public String getText2(){
        return mText2;
    }

}
