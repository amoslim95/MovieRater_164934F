package com.example.amoslim_164934f.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_movie.*

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
        if (titlename.isEmpty()) txtname.error = "Field empty, enter movie title"
        else if (desc.isEmpty()) txtdesc.error = "Field empty, Enter Description"
        else if (resdate.isEmpty()) txtdaterelease.error = "Field empty"
        else {


            // for laugauge checkbox
            if (rbtneng.isChecked == true) laugauge = "English"
            else if (rbtnchi.isChecked == true) laugauge = "Chinese"
            else if (rbtnmalay.isChecked == true) laugauge = "Malay"
            else if (rbtntamil.isChecked == true) laugauge = "Tamil"

            // Show Toast Display

            //not suitable for audience radio button
            if (chblang.isChecked == true) {
                reasonLang = "Langauge"
            } else {
                reasonLang = ""
            }

            if (chbvio.isChecked == true) {
                reasonVio = "Violence"
            } else {
                reasonVio = ""
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










