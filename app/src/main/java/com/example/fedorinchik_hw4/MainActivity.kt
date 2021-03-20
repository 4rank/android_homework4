package com.example.fedorinchik_hw4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bnv: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bnvFun()
    }

    private fun bnvFun() {
        bnv = findViewById(R.id.bot_nav_view_first)
        val navigationController = findNavController(R.id.navFragment)
        bnv.setupWithNavController(navigationController)
    }
}