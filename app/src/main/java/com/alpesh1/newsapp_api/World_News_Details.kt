package com.alpesh1.newsapp_api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alpesh1.newsapp_api.databinding.ActivityWorldNewsDetailsBinding
import com.bumptech.glide.Glide

class World_News_Details : AppCompatActivity() {

    lateinit var binding: ActivityWorldNewsDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorldNewsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backArrow.setOnClickListener {

            var intent = Intent(this,world_Fragment.javaClass)
            startActivity(intent)
            finish()
        }

        var pos = intent.getIntExtra("pos",0)
        var model = world_Fragment.List[pos]

        binding.txtTitle.text = model.title.toString()
        binding.txtPublish.text = model.publishedAt.toString()
        binding.txtAuthor.text = model.author.toString()
        binding.txtDescription.text = model.description.toString()
        Glide.with(this).load(model.urlToImage).into(binding.imgImage)
        binding.txtContent.text = model.content.toString()

    }
}