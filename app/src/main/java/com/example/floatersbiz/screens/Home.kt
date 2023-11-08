package com.example.floatersbiz.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.floatersbiz.R
import com.example.floatersbiz.databinding.ActivityHomeBinding
import com.example.floatersbiz.homefragments.CartFragment
import com.example.floatersbiz.homefragments.FindFragment
import com.example.floatersbiz.homefragments.HomeFragment
import com.example.floatersbiz.homefragments.MoreFragment

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.icShop -> replaceFragment(HomeFragment())
                R.id.icExplore -> replaceFragment(FindFragment())
                R.id.icCart -> replaceFragment(CartFragment())
                R.id.icMore -> replaceFragment(MoreFragment())

                else -> {
                }
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}