package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.showimage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.codesroots.osamaomar.shopgate.R
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val url = intent.getStringExtra("url")
        Glide.with(this).load(url).into(img)
    }
}
