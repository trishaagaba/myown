package com.example.myown.Activities

import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.TimePicker
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myown.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.sql.Time
import java.util.Calendar


class CreateRoutine : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_routine);

        //a functionality for the clear button
        val clearBtn = findViewById<AppCompatImageView>(R.id.clearBtn);
        clearBtn.setOnClickListener{
            finish()
                //takes you back to previous page
        }



        val addActionButton = findViewById<FloatingActionButton>(R.id.AddAction)
        val addEventButton = findViewById<FloatingActionButton>(R.id.AddEvent)

        //setting on click listeners to the various buttons
        addActionButton.setOnClickListener { addAction() }
        addEventButton.setOnClickListener { addEvent() }


//show time picker dialog
        val calendar = Calendar.getInstance();
        val hour = calendar.get(Calendar.HOUR_OF_DAY);
        val minute = calendar.get(Calendar.MINUTE);
//        val timePickerDialog =  TimePickerDialog(this,  TimePickerDialog.onTimeSetListener(){
//
//            public void onTimeSet(TimePicker view, val hour, val minute){
//
////                do sth with the selected time
//            }, hour, minute, false);
//            timePickerDialog.show();
//        }
        }

     fun addEvent(){
        val intent = Intent(this,SelectEvent::class.java)
        startActivity(intent)
    }
    fun addAction(){
        val intent = Intent(this,SelectThing::class.java)
        startActivity(intent)
    }
    }

