package com.example.androidapp;

import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class GlideImageLoader implements ImageLoader {

    @Override
    public void loadImage(String imageUrl, ImageView imageView) {
        Glide.with(imageView).load(imageUrl).into(imageView);
    }
}