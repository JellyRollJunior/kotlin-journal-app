package com.example.kotlinjournal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinjournal.databinding.ActivityAffirmationsBinding
import com.example.kotlinjournal.model.Affirmation

class AffirmationMain : AppCompatActivity() {

    private lateinit var binding: ActivityAffirmationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAffirmationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}