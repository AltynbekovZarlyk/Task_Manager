package com.example.task_manager.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url: String) {
    Picasso.get().load(url).into(this)
}