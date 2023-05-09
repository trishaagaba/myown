package com.example.myown.Activities




import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myown.Fragments.*
import com.example.myown.R

import com.google.android.material.bottomnavigation.BottomNavigationView




  class MainActivity : AppCompatActivity(){
    private val favourites = FavouritesFragment()
    private val routines = RoutinesFragment()
    private val things = ThingsFragment()
    private val settings = SettingsFragment()
    private val ideas = IdeasFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.favouritesnbtn -> replaceFragment(favourites)
                R.id.routinesnbtn -> replaceFragment(routines)
                R.id.thingsnbtn -> replaceFragment(things)
                R.id.ideasnbtn -> replaceFragment(ideas)
                R.id.settingsnbtn -> replaceFragment(settings)
            }
            true
        }

        replaceFragment(favourites)
    }
    private fun replaceFragment(fragment : Fragment){
        if(fragment!=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,fragment)
            transaction.commit()
        }
    }


}