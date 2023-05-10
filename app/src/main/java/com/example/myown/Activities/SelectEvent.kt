package com.example.myown.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myown.R


class SelectEvent : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val selectEvent = findViewById<TextView>(R.id.selectEventTime)

        selectEvent.setOnClickListener {
            setTime()
        }

    }


    public fun setTime() {
        val intent = Intent(this, CreateRoutine::class.java)
        intent.putExtra("timeSet", true)
        startActivity(intent)

    }


}

