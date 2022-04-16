package com.example.kotlinjournal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinjournal.adapter.ItemAdapter
import com.example.kotlinjournal.data.Datasource
import com.example.kotlinjournal.databinding.ActivityAffirmationsBinding
import com.example.kotlinjournal.databinding.ActivityMainBinding
import javax.sql.DataSource

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // launch apps
        binding.birthdayBtn.setOnClickListener { launchBirthday() }
        binding.diceRollBtn.setOnClickListener { launchDiceRoller() }
        binding.tipTimeBtn.setOnClickListener { launchTipTime() }
        binding.affirmationsBtn.setOnClickListener { launchAffirmations() }
    }

    private fun launchBirthday() {
        listIntent = Intent(this, BirthdayCard::class.java)
        startActivity(listIntent)
    }

    private fun launchDiceRoller() {
        listIntent = Intent(this, DiceRoller::class.java)
        startActivity(listIntent)
    }

    private fun launchTipTime() {
        listIntent = Intent(this, TipCalculator::class.java)
        startActivity(listIntent)
    }

    private fun launchAffirmations() {
        listIntent = Intent(this, AffirmationMain::class.java)
        startActivity(listIntent)
    }
}
