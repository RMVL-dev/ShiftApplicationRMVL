package com.example.shiftapplicationrmvl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shiftapplicationrmvl.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}