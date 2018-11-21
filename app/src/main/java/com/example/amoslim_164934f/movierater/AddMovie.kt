package com.example.amoslim_164934f.movierater

import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_movie.*
import java.util.*

class AddMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)


        // Hide or show checkbox when selected not suitable for all audience checkbox
        chbaudi.setOnClickListener{
            if(chbaudi.isChecked)
            {
                chklinear.visibility = View.VISIBLE
            }
            else
            {
                chklinear.visibility = View.INVISIBLE
                chblang.isChecked= false
                chbvio.isChecked= false
            }
        }
        txtdaterelease.setOnClickListener{
            val c = Calendar.getInstance()
            val year: Int = c.get(Calendar.YEAR)
            val month: Int = c.get(Calendar.MONTH)
            val day: Int = c.get(Calendar.DAY_OF_MONTH)

            val dpd = DatePickerDialog(this, android.R.style.Theme_Holo_Dialog, DatePickerDialog.OnDateSetListener{ datePicker, year, monthOfYear, dayOfMonth ->
                if(dayOfMonth < 10){
                    txtdaterelease.setText("0$dayOfMonth-${monthOfYear+1}-$year")
                }else{
                    txtdaterelease.setText("$dayOfMonth-${monthOfYear+1}-$year")
                }

            }, year, month, day)
            dpd.show()
        }

    }

    //add movie button action
    fun btnAddmovie(v: View) {

        //delcare value
        var titlename = txtname.text.toString()
        var desc = txtdesc.text.toString()
        var resdate = txtdaterelease.text.toString()
        var laugauge = ""
        var audichecked = ""
        var reasonVio = ""
        var reasonLang = ""
        var NoReason = ""
        rbtneng.isChecked

        //vaildation if field/textbox is empty
        when {
            titlename.isEmpty() -> txtname.error = "Field empty, enter movie title"
            desc.isEmpty() -> txtdesc.error = "Field empty, Enter Description"
            resdate.isEmpty() -> txtdaterelease.error = "Field empty"
            else -> {


                // for laugauge checkbox
                //not suitable for audience radio button
                when {
                    rbtneng.isChecked -> laugauge = "English"
                    rbtnchi.isChecked -> laugauge = "Chinese"
                    rbtnmalay.isChecked -> laugauge = "Malay"
                    rbtntamil.isChecked -> laugauge = "Tamil"

                }

                //not suitable for audience radio button
                reasonLang = if (chblang.isChecked == true) {
                    "Langauge"
                } else {
                    ""
                }

                reasonVio = if (chbvio.isChecked == true) {
                    "Violence"
                } else {
                    ""
                }

                if (chbaudi.isChecked) {
                    audichecked = "true"
                } else {
                    audichecked = "false"
                    NoReason = "null"

                }

                // Show Toast Display
                Toast.makeText(applicationContext, "Title = ${titlename}"
                        + "\n" + "Overview = ${desc}"
                        + "\n" + "Release date = ${resdate}"
                        + "\n" + "Lauguage = ${laugauge}"
                        + "\n" + "Not Suitable for ages = ${audichecked}"
                        + "\n" + "Reason: ${NoReason} "
                        + "\n" + "${reasonLang}"
                        + "\n" + "${reasonVio}"
                        , Toast.LENGTH_LONG).show()
            }
        }

    }

}