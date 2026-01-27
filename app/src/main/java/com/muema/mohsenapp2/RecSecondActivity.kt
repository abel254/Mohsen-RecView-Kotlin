package com.muema.mohsenapp2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muema.mohsenapp2.databinding.ActivityRecSecondBinding

class RecSecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val intent = intent

        val image = intent?.getIntExtra("image", 0)
        val title = intent?.getStringExtra("title")
        val ingredients = intent?.getStringExtra("ingredients")


        if (image != null){
            binding.imageView.setImageResource(image)
        }

        binding.txtTitleSecondActivity.text = title
        binding.txtIngSecondActivity.text = ingredients


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}