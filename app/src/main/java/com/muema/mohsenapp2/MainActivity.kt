package com.muema.mohsenapp2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muema.mohsenapp2.databinding.ActivityMainBinding
import com.muema.mohsenapp2.swipe_rec.SwipeRecyclerActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRecyclerView.setOnClickListener {

            val intent = Intent(this, RecylerViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnGridRecyView.setOnClickListener {
            val intent = Intent(this, GridRecyclerActivity::class.java)
            startActivity(intent)
        }

        binding.btnSwipeRec.setOnClickListener {
            val intent = Intent(this, SwipeRecyclerActivity::class.java)
            startActivity(intent)
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}