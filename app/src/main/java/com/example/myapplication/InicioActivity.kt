package com.example.myapplication


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_inicio.*
import java.text.SimpleDateFormat
import java.util.*


class InicioActivity : AppCompatActivity() {
    var cal: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        var autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.autoCompleteText)

        val option = arrayOf("Newark Airport"," John F. Kennedy International airport", "Laguardia Airport", "SOHO","CHINATOWNZONA", "LITTLE ITALY", "CHELSEA","MIDTOWN", "LINCOLN SQUARE", "TRIBECA","BOWERY", "MIDTOWN SOUTH", "WEST VILLAGE","CLINTON")
        val arrayAdapter = ArrayAdapter(this,R.layout.option_item,option)
        autoCompleteTextView.setText(arrayAdapter.getItem(0).toString(),false)
        autoCompleteTextView.setAdapter(arrayAdapter)
        autoCompleteText.dropDownHeight = 600


        inputDate.inputType = InputType.TYPE_NULL;
        inputTime.inputType = InputType.TYPE_NULL;



        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            updateDateInView()
        }

        inputDate.setOnClickListener {
            DatePickerDialog(this@InicioActivity,android.R.style.Theme_DeviceDefault_Dialog_NoActionBar,dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
        }
        val timePicker = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hourOfDay)
            cal.set(Calendar.MINUTE,minute)
            updateTimeInView()
        }


        inputTime.setOnClickListener {
            TimePickerDialog(this@InicioActivity,android.R.style.Theme_DeviceDefault_Dialog_NoActionBar,timePicker,
                    cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE), true).show()       }

        btnResultadoScreen.setOnClickListener {
            val myIntent = Intent(this, ResultadoActivity::class.java)
            this.startActivity(myIntent)
        }

    }
    private fun updateDateInView(){
        val myFormat = "MM/dd/yyyy"
        val sdf = SimpleDateFormat(myFormat,Locale.US)
        val text = sdf.format(cal.time)
        inputDate.setText(text)
    }

    private  fun updateTimeInView(){
        val myFormat = "HH:mm a"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        val text = sdf.format(cal.time)
        inputTime.setText(text)
    }
}