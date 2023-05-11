package com.example.myown.Activities

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myown.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class SelectRoutine : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_routine);

        val selectRoutinebtn = findViewById<FloatingActionButton>(R.id.selectRoutineBtn)
        selectRoutinebtn.setOnClickListener{createRoutine()}

        val backbtn = findViewById<AppCompatImageView>(R.id.backbtn)
        backbtn.setOnClickListener{
            finish()
        }
        }

     private fun createRoutine(){
        val intent= Intent(this, CreateRoutine::class.java)
        startActivity(intent)
    }
    }


