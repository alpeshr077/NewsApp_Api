package com.alpesh1.newsapp_api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.alpesh1.newsapp_api.databinding.ActivityNewsDetailsBinding
import com.bumptech.glide.Glide

class News_Details : AppCompatActivity() {

    lateinit var binding: ActivityNewsDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backArrow.setOnClickListener {

            var intent = Intent(this,MainActivity.javaClass)
            startActivity(intent)
            finish()
        }

        var pos = intent.getIntExtra("pos",0)
        var model = MainActivity.List[pos]

        binding.txtTitle.text = model.title.toString()
        binding.txtPublish.text = model.publishedAt.toString()
        binding.txtAuthor.text = model.author.toString()
        binding.txtDescription.text = model.description.toString()
        Glide.with(this).load(model.urlToImage).into(binding.imgImage)
        binding.txtContent.text = model.content.toString()

    }
}