package com.example.kotlinjournal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinjournal.adapter.AffirmationItemAdapter
import com.example.kotlinjournal.data.AffirmationsDataSource
import com.example.kotlinjournal.databinding.ActivityAffirmationsBinding

/**
 * In this task, you will set up a RecyclerView to display the list of Affirmations.
 * There are a number of pieces involved in creating and using a RecyclerView.
 * You can think of them as a division of labor. The diagram below shows an overview,
 * and you will learn more about each piece as you implement it.
 *
 *     item - One data item of the list to display. Represents one Affirmation object in your app.
 *     Adapter - Takes data and prepares it for RecyclerView to display.
 *     ViewHolders - A pool of views for RecyclerView to use and reuse to display affirmations.
 *     RecyclerView - Views on screen
 *
 * RecyclerView supports displaying items in different ways, such as a linear list or a grid.
 * Arranging the items is handled by a LayoutManager. The Android framework provides layout
 * managers for basic item layouts. The Affirmations app displays items as a vertical list,
 * so you can use the LinearLayoutManager.
 */
class AffirmationMain : AppCompatActivity() {

    private lateinit var binding: ActivityAffirmationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAffirmationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myDataset = AffirmationsDataSource().loadAffirmations()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = AffirmationItemAdapter(this, myDataset)

        /**
         * Since the layout size of your RecyclerView is fixed in the activity layout, you can set
         * the setHasFixedSize parameter of the RecyclerView to true. This setting is only needed to
         * improve performance. Use this setting if you know that changes in content do not change
         * the layout size of the RecyclerView.
         */
        recyclerView.setHasFixedSize(true)
    }
}