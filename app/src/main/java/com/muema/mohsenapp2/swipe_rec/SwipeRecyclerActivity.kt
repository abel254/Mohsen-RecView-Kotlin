package com.muema.mohsenapp2.swipe_rec

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muema.mohsenapp2.R
import com.muema.mohsenapp2.databinding.ActivitySwipeRecyclerBinding
import java.util.Collections

class SwipeRecyclerActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySwipeRecyclerBinding
    private lateinit var items: ArrayList<String>
    private lateinit var itemsArrayList: ArrayList<SwipeDataClass>

    private lateinit var myAdapter: SwipeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySwipeRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.swipeRec

        itemsArrayList = arrayListOf()

        items = arrayListOf(
            "Positon 01",
            "Positon 02",
            "Positon 03",
            "Positon 04",
            "Positon 05",
            "Positon 06",
            "Positon 07",
            "Positon 08",
            "Positon 09",
            "Positon 10",
            "Positon 11",
            "Positon 12",
        )

        for (i in items.indices){
            val item = SwipeDataClass(items[i])
            itemsArrayList.add(item)
        }

        myAdapter = SwipeAdapter(itemsArrayList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = myAdapter



        // Swiping Feature

        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0){
            override fun onMove(
                recyclerView: RecyclerView,
                source: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {

                val sourcePosition = source.adapterPosition
                val targetPosition = target.adapterPosition

                Collections.swap(itemsArrayList, sourcePosition, targetPosition)
                myAdapter.notifyItemMoved(sourcePosition, targetPosition)

                return true
            }

            override fun onSwiped(
                viewHolder: RecyclerView.ViewHolder,
                direction: Int
            ) {
                TODO("Not yet implemented")
            }

        })

        itemTouchHelper.attachToRecyclerView(recyclerView)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}