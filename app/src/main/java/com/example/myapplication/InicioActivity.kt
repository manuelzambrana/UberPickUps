package com.example.myapplication

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_inicio.*
import java.text.SimpleDateFormat
import java.util.*

class InicioActivity : AppCompatActivity() {
    var cal = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        var autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.autoCompleteText)
        val option = arrayOf("a", "b", "c","a", "b", "c","a", "b", "c","a", "b", "c","a", "b", "c","a", "b", "c")
        val arrayAdapter = ArrayAdapter(this,R.layout.option_item,option)
        autoCompleteTextView.setText(arrayAdapter.getItem(0).toString(),false)
        autoCompleteTextView.setAdapter(arrayAdapter)
        autoCompleteTextView.threshold = 1
        autoCompleteText.dropDownHeight = 600


        inputDate.inputType = InputType.TYPE_NULL;


        val dateSetListener = object: DatePickerDialog.OnDateSetListener{
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                updateDateInView()
            }
        }
        inputDate.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@InicioActivity,dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })

    }
    private fun updateDateInView(){
        val myFormat = "MM/dd/yyyy"
        val sdf = SimpleDateFormat(myFormat,Locale.US)
        val text = sdf.format(cal.time)
        inputDate.setText(text)
    }
}