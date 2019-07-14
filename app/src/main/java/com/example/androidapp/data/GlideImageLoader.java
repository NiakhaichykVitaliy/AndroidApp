package com.example.androidapp.data;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.androidapp.R;


public class GlideImageLoader implements ImageLoader {

    @Override
    public void loadImage(String imageUrl, ImageView imageView) {
        Glide.with(imageView)
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_loading)
                .into(imageView);
    }
}