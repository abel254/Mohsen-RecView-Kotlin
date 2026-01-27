package com.muema.mohsenapp2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muema.mohsenapp2.databinding.ActivityRecylerViewBinding

class RecylerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecylerViewBinding
    private lateinit var imageId: Array<Int>
    private lateinit var names: Array<String>
    private lateinit var ingredients: Array<String>

    private lateinit var itemArrayList: ArrayList<Pizza>

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityRecylerViewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        imageId = arrayOf(
            R.drawable.pizza1,
            R.drawable.pizza2,
            R.drawable.pizza3,
            R.drawable.pizza4,
            R.drawable.pizza5,
            R.drawable.pizza1,
            R.drawable.pizza2,
            R.drawable.pizza3,
            R.drawable.pizza4,
            R.drawable.pizza5,
            R.drawable.pizza1,
            R.drawable.pizza2,
            R.drawable.pizza3,
            R.drawable.pizza4,
            R.drawable.pizza5,
        )

        names = arrayOf(
            "pizza1",
            "pizza2",
            "pizza3",
            "pizza4",
            "pizza5",
            "pizza6",
            "pizza7",
            "pizza8",
            "pizza9",
            "pizza10",
            "pizza11",
            "pizza12",
            "pizza13",
            "pizza14",
            "pizza15",
        )

        ingredients = arrayOf(
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
        )



        binding.recView.layoutManager = LinearLayoutManager(this)
        binding.recView.setHasFixedSize(true)

        itemArrayList = arrayListOf()

        getData()

        binding.recView.adapter = RecAdapter(itemArrayList)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getData(){
        for (i in imageId.indices){
            val pizza = Pizza(imageId[i], names[i], ingredients[i])
            itemArrayList.add(pizza)
        }
    }
}