package com.example.myown.Activities

import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myown.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Calendar


class CreateRoutine : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences;
    private val SHARED_PREFS_KEY = "MySharedPreferences"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_routine);


        //a functionality for the clear button
        val clearBtn = findViewById<AppCompatImageView>(R.id.clearBtn);
        clearBtn.setOnClickListener {
            finish()
            //takes you back to previous page
        }

        sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE)
//get the various shared preferences when you load the page
        getTimeSharedPreferences()
        getLocationSharedPreferences()


        val addActionButton = findViewById<FloatingActionButton>(R.id.AddAction)
        val addEventButton = findViewById<FloatingActionButton>(R.id.AddEvent)

        //setting on click listeners to the various buttons
        addActionButton.setOnClickListener { addAction() }
        addEventButton.setOnClickListener { addEvent() }


//use intents to get the extra actions
        val timeSet = intent.getBooleanExtra("timeSet", false)
        if (timeSet) {
            showTimePickerDialog()
            intent.putExtra("timeSet", false)
        }
        val locationSet = intent.getBooleanExtra("locationSet", false)
        if (locationSet) {
            showLocationDialog()
            intent.putExtra("locationSet", false)
        }
    }

        //defining the different preferences to pull the values
        private fun getTimeSharedPreferences() {
            val selectedTime1 = sharedPreferences.getString("TimePrefs", null)
            if (selectedTime1 != null) {
                val eventRowLayout = layoutInflater.inflate(R.layout.event_row, null)
                // Replace the TextView with id @+id/selectedTimeTV with the inflated LinearLayout
                val selectedtimecontainer = findViewById<ViewGroup>(R.id.selectedtimecontainer)
                val selectTimeTV = findViewById<TextView>(R.id.selectTime)
                val index = selectedtimecontainer.indexOfChild(selectTimeTV)
                selectedtimecontainer.removeView(selectTimeTV)
                selectedtimecontainer.addView(eventRowLayout, index)
                eventRowLayout.id = R.id.selectTime
                findViewById<TextView>(R.id.tv_AddTime).text = "The time is $selectedTime1"

            }
        }
            private fun getLocationSharedPreferences() {
                val inputLocation = sharedPreferences.getString("LocationPrefs", null)
                if (inputLocation != null) {
                    val locationRowLayout = layoutInflater.inflate(R.layout.location_row, null)
                    // Replace the TextView with id @+id/selectedTimeTV with the inflated LinearLayout
                    val selectedtimecontainer = findViewById<ViewGroup>(R.id.selectedtimecontainer)
                    val selectTimeTV = findViewById<TextView>(R.id.selectTime)
                    val index = selectedtimecontainer.indexOfChild(selectTimeTV)
                    selectedtimecontainer.removeView(selectTimeTV)
                    selectedtimecontainer.addView(locationRowLayout, index)
                    locationRowLayout.id = R.id.selectTime
                    findViewById<TextView>(R.id.tv_AddLocation).text = "The location is $inputLocation"
                }
            }
        override fun onDestroy() {
            super.onDestroy()
            sharedPreferences.edit().clear().apply()
        }
//show time picker dialog

        fun showTimePickerDialog() {

            val calendar = Calendar.getInstance();
            val hour = calendar.get(Calendar.HOUR_OF_DAY);
            val minute = calendar.get(Calendar.MINUTE);
            val amPm = calendar.get(Calendar.AM_PM)
            val timePickerDialog =
                TimePickerDialog(
                    this,
                    TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->

                        val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                        val amPmText = if (amPm == Calendar.AM) " AM" else " PM"
                       val selectedTime1 = "$selectedTime.$amPmText"
//                        updateEventRow(selectedTime1)

                        val eventRowLayout = layoutInflater.inflate(R.layout.event_row, null)
                        // Replace the TextView with id @+id/selectedTimeTV with the inflated LinearLayout
                        val selectedtimecontainer = findViewById<ViewGroup>(R.id.selectedtimecontainer)
                        val selectTimeTV = findViewById<TextView>(R.id.selectTime)
                        val index = selectedtimecontainer.indexOfChild(selectTimeTV)
                        selectedtimecontainer.removeView(selectTimeTV)
                        selectedtimecontainer.addView(eventRowLayout, index)
                        eventRowLayout.id = R.id.selectTime
                        findViewById<TextView>(R.id.tv_AddTime).text = "The time is $selectedTime1"


//store the value in shared preferences
                        val editor = sharedPreferences.edit()
                        editor.putString("TimePrefs", selectedTime1)
                        editor.apply()
                    },
                    hour,
                    minute,
                    false
                );

            timePickerDialog.show();
        }

//    private fun updateEventRow(selectedTime1: String) {
//        val timecontainer = findViewById<LinearLayout>(R.id.selectedtimecontainer);
//        val event_row_layout = findViewById<LinearLayout>(R.id.event_row_layout)
//      timecontainer.visibility= View.GONE
//        event_row_layout.visibility= View.VISIBLE
//        // Change the text in the text view with id @+id/tv_AddTime
//        findViewById<TextView>(R.id.selectTime).text = "The time is $selectedTime1"
//    }


        fun showLocationDialog(){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Enter your location")

            val input = EditText(this)
            builder.setView(input)

            builder.setPositiveButton("OK"){
                dialog, _ -> dialog.dismiss()
                val inputLocation = input.text.toString()

//
                val locationRowLayout = layoutInflater.inflate(R.layout.location_row, null)
                // Replace the TextView with id @+id/selectedTimeTV with the inflated LinearLayout
                val selectedtimecontainer = findViewById<ViewGroup>(R.id.selectedtimecontainer)
                val selectTimeTV = findViewById<TextView>(R.id.selectTime)
                val index = selectedtimecontainer.indexOfChild(selectTimeTV)
                selectedtimecontainer.removeView(selectTimeTV)
                selectedtimecontainer.addView(locationRowLayout, index)
                locationRowLayout.id = R.id.selectTime


                findViewById<TextView>(R.id.tv_AddLocation).text = "The location is $inputLocation"

                //save the value to shared preferences
                val editor = sharedPreferences.edit()
                editor.putString("locationPrefs", inputLocation)
                editor.apply()
            }

            builder.setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }

            builder.show()
        }

//private fun updateEventRow2(inputLocation: String) {
//        val timecontainer = findViewById<LinearLayout>(R.id.selectedtimecontainer);
//        val location_row_layout = findViewById<LinearLayout>(R.id.location_row_layout)
//        timecontainer.visibility= View.GONE
//        location_row_layout.visibility= View.VISIBLE
//        // Change the text in the text view with id @+id/tv_AddTime
//        findViewById<TextView>(R.id.selectTime).text = "The location is $inputLocation"
//    }


        fun addEvent() {
            val intent = Intent(this, SelectEvent::class.java)
            startActivity(intent)
        }

        fun addAction() {
            val intent= Intent(this, SelectThing::class.java)
            startActivity(intent)
        }
    private fun oldUpdateRowCode(){
        // Inflate the LinearLayout resource file

        //for location

    }

}


