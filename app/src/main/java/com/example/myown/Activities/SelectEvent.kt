package com.example.myown.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myown.R



class SelectEvent : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_select_event)
        val selectEvent = findViewById<TextView>(R.id.selectEventTime)
        selectEvent.setOnClickListener { setTime() }

        val selectEventTimeTV2 = findViewById<TextView>(R.id.selectEventTimeTV2)
        selectEventTimeTV2.setOnClickListener{setLocation()}

        val selectEventTimeTV3 = findViewById<TextView>(R.id.selectEventTimeTV3)
        selectEventTimeTV3.setOnClickListener{setLocation()}

        val selectEventTimeTV4 = findViewById<TextView>(R.id.selectEventTimeTV4)
        selectEventTimeTV4.setOnClickListener{setLocation()}

        val selectEventTimeTV5 = findViewById<TextView>(R.id.selectEventTimeTV5)
        selectEventTimeTV5.setOnClickListener{setLocation()}

        val selectEventTimeTV6 = findViewById<TextView>(R.id.selectEventTimeTV6)
        selectEventTimeTV6.setOnClickListener{setLocation()}

        val selectEventTimeTV7 = findViewById<TextView>(R.id.selectEventTimeTV7)
        selectEventTimeTV7.setOnClickListener{setLocation()}




    }

    private fun setLocation() {
      val intent = Intent(this, CreateRoutine::class.java)
        intent.putExtra("locationSet",true)
        startActivity(intent)
    }


    private fun setTime() {
        val intent = Intent(this, CreateRoutine::class.java)
        intent.putExtra("timeSet", true)
        startActivity(intent)

    }


}

