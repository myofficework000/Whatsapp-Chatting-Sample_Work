package com.example.whatsappfeatureapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import com.example.whatsappfeatureapp.R
import com.example.whatsappfeatureapp.databinding.ActivityMainBinding
import com.example.whatsappfeatureapp.databinding.ActivityTabLayoutBinding
import com.example.whatsappfeatureapp.databinding.FragmentTabLayoutMainBinding
import com.example.whatsappfeatureapp.view.adapter.TabLayoutAdapter
import com.example.whatsappfeatureapp.view.fragment.ChatFragment
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val tabBinding by lazy { FragmentTabLayoutMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.mainToolbar)
        binding.actionBarFeatureSearch.setOnClickListener {
            Snackbar.make(binding.root, "W.I.P.", Snackbar.LENGTH_SHORT).show()
        }
        //insertFragment(ChatFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean = true.also {
        menuInflater.inflate(R.menu.toobar_options, menu)
    }

    private fun insertFragment(chatFragment: Fragment) {
        val fragmentManger = supportFragmentManager
        val fragmentTransaction = fragmentManger.beginTransaction()
        fragmentTransaction.replace(androidx.fragment.R.id.fragment_container_view_tag,chatFragment)
        fragmentTransaction.commit()
    }
}