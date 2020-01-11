package com.example.android.houseapp

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.android.houseapp.R.id.navigation_albums
import com.example.android.houseapp.R.id.navigation_posts
import com.example.android.houseapp.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(findNavController(R.id.nav_host_fragment)) {
            navView.setupWithNavController(this)
            addOnDestinationChangedListener(NavController.OnDestinationChangedListener(::visibilityNavElements))
        }
    }

    private fun visibilityNavElements(nc: NavController, destination: NavDestination, b: Bundle?) {
        navView.visibility = when (destination.id) {
            navigation_posts, navigation_albums -> VISIBLE
            else -> GONE
        }
    }
}
