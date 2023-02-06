package com.example.whatsappfeatureapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.whatsappfeatureapp.R
import com.example.whatsappfeatureapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.mainToolbar)
        binding.actionBarFeatureSearch.setOnClickListener {
            Snackbar.make(binding.root, "W.I.P.", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean = true.also {
        menuInflater.inflate(R.menu.toobar_options, menu)
    }
}