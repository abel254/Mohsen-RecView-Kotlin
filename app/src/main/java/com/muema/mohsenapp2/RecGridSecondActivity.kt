package com.muema.mohsenapp2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muema.mohsenapp2.databinding.ActivityRecGridSecondBinding

class RecGridSecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecGridSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecGridSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent

        val image = intent.getIntExtra("image", 0)
        val title = intent.getStringExtra("title")
        val ingredients = intent.getStringExtra("ingredients")

        binding.imageView2.setImageResource(image)
        binding.txtTitleSecondActivity2.text = title
        binding.txtIngSecondActivity2.text = ingredients



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}