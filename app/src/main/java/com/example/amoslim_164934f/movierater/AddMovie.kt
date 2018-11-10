package com.example.amoslim_164934f.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_movie.*

class AddMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)



        chbaudi.setOnClickListener(View.OnClickListener {
            if(chbaudi.isChecked == true)
            {
                chklinear.setVisibility(View.VISIBLE)
            }
            else
            {
                chklinear.setVisibility(View.INVISIBLE)
            }
        })


    }

    fun btnAddmovie(v: View) {

        var titlename = txtname.text.toString()
        var desc = txtdesc.text.toString()
        var resdate = txtdaterelease.text.toString()
        var laugauge = ""
        var audichecked = ""
        var reason1 = ""
        var reason2 = ""
        var reason3 = ""
        rbtneng.isChecked == true

        if (titlename.length == 0) {
            txtname.setError("Field empty, enter movie title");

        } else if (desc.length == 0) {
            txtdesc.setError("Field empty, Enter Description");

        } else if (resdate.trim().length == 0) {
            txtdaterelease.setError("Field empty");

        } else {


            // for laugauge checkbox
            if (rbtneng.isChecked == true) {
                laugauge = "English"
            }
            else if (rbtnchi.isChecked == true) {
                laugauge = "Chinese"
            }
            else if (rbtnmalay.isChecked == true) {
                laugauge = "Malay"
            }
            else if (rbtntamil.isChecked == true) {
                laugauge = "Tamil"
            }



//not suitable for audience radio button
            if (chblang.isChecked == true) {
                reason1 = "Langauge"
            } else {
                reason1 = ""
            }

            if (chbvio.isChecked == true) {
                reason2 = "Violence"
            } else {
                reason2 = ""
            }


            if (chbaudi.isChecked == true) {
                audichecked = "true"
            } else {
                audichecked = "false"
                reason3 = "null"
                reason2 =""
                reason1 = ""
            }



            // Show Toast Display
            Toast.makeText(getApplicationContext(), "Title = ${titlename}"
                    + "\n" + "Overview = ${desc}"
                    + "\n" + "Release date = ${resdate}"
                    + "\n" + "Lauguage = ${laugauge}"
                    + "\n" + "Not Suitable for ages = ${audichecked}"
                    + "\n" + "Reason: ${reason3} "
                    + "\n" + "${reason1}"
                    + "\n" + "${reason2}"
                    , Toast.LENGTH_SHORT).show()

        }

    }


}










