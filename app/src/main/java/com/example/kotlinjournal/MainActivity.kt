package com.example.kotlinjournal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinjournal.databinding.ActivityMainBinding

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
        binding.lemonadeBtn.setOnClickListener { launchLemonade() }
        binding.tipTimeBtn.setOnClickListener { launchTipTime() }
        binding.affirmationsBtn.setOnClickListener { launchAffirmations() }
        binding.dogglersBtn.setOnClickListener { launchDogglers() }
        binding.unscrambleBtn.setOnClickListener { launchUnscramble() }
    }

    private fun launchBirthday() {
        listIntent = Intent(this, BirthdayCard::class.java)
        startActivity(listIntent)
    }

    private fun launchDiceRoller() {
        listIntent = Intent(this, DiceRoller::class.java)
        startActivity(listIntent)
    }

    private fun launchLemonade() {
        listIntent = Intent(this, Lemonade::class.java)
        startActivity(listIntent)
    }

    private fun launchTipTime() {
        listIntent = Intent(this, TipCalculator::class.java)
        startActivity(listIntent)
    }

    private fun launchAffirmations() {
        listIntent = Intent(this, AffirmationsMain::class.java)
        startActivity(listIntent)
    }

    private fun launchDogglers() {
        listIntent = Intent(this, Dogglers::class.java)
        startActivity(listIntent)
    }

    private fun launchUnscramble() {
        listIntent = Intent(this, Unscramble::class.java)
        startActivity(listIntent)
    }
}
