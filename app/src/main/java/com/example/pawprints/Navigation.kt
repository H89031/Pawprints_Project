package com.example.pawprints

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.pawprints.databinding.ActivityNavigationBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class Navigation : AppCompatActivity() {


    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_navigation) as NavHostFragment
        val navController = navHostFragment.navController

        navView.setupWithNavController(navController)
        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    navController.popBackStack(R.id.navigation_home, false) // Keep HomeFragment in the back stack
                    navController.navigate(R.id.navigation_home)
                    true
                }
                R.id.navigation_profile -> {
                    navController.popBackStack(R.id.navigation_profile, false) // Keep DashboardFragment in the back stack
                    navController.navigate(R.id.navigation_profile)
                    true
                }
                R.id.navigation_report -> {
                    navController.popBackStack(R.id.navigation_report, false) // Keep NotificationsFragment in the back stack
                    navController.navigate(R.id.navigation_report)
                    true
                }
                R.id.GMaps -> {
                    navController.popBackStack(R.id.GMaps, false) // Keep NotificationsFragment in the back stack
                    navController.navigate(R.id.GMaps)
                    true
                }
                R.id.navigation_search -> {
                    navController.popBackStack(R.id.navigation_search, false) // Keep NotificationsFragment in the back stack
                    navController.navigate(R.id.navigation_search)
                    true
                }
                else -> false
            }
        }
    }
}