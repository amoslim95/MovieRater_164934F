package com.example.amoslim_164934f.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_movie.*
import java.text.SimpleDateFormat
import java.util.*

class AddMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)

        //Format and  set date to the edittext

        val releaseDate: String = SimpleDateFormat("dd-MM-YYYY").format(Calendar.getInstance().getTime())
        txtdaterelease.text



        fun legalDoB(): Boolean {
            val releaseDate = txtdaterelease.text.toString()
            val df = SimpleDateFormat("MM/dd/yy")
            df.isLenient = false

            return false
        }








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



    fun btnAddmovie(v: View){

        var titlename = txtname.text.toString()
        var desc = txtdesc.text.toString()
        var resdate = txtdaterelease.text.toString()
        var laugauge = ""
        var audichecked =""
        var reason1 = ""
        var reason2 = ""
        var reason3= ""


        if (titlename == "") {
            txtname.setError("Field empty");
        }
        else if (desc == ""){
            txtdesc.setError("Field empty");
        }

        else if (resdate == ""){
            txtdaterelease.setError("Field empty");
        }
        else {
// for laugauge checkbox
            if (rbtneng.isChecked == true) {
                laugauge = "English"
            } else if (rbtnchi.isChecked == true) {
                laugauge = "Chinese"
            } else if (rbtnmalay.isChecked == true) {
                laugauge = "Malay"
            } else if (rbtntamil.isChecked == true) {
                laugauge = "Tamil"
            } else
                laugauge = "null"


//not suitable for audience radio button
            if (chbaudi.isChecked == false) {
                audichecked = "true"
                reason3 = "null"

            } else {
                audichecked = "false"

            }

            if (chblang.isChecked == true) {
                reason1 = "Langauge"
            } else
                reason1 = ""

            if (chbvio.isChecked == true) {
                reason2 = "Violence"
            } else {
                reason2 = ""
            }
            // Show Toast Display
            Toast.makeText(getApplicationContext(), "Title = ${titlename}"
                    + "\n" + "Overview = ${desc}"
                    + "\n" + "Release date = ${resdate}"
                    + "\n" + "Lauguage = ${laugauge}"
                    + "\n" + "Suitable for ages = ${audichecked}"
                    + "\n" + "Reason: ${reason3} "
                    + "\n" + "${reason1}"
                    + "\n" + "${reason2}"
                    , Toast.LENGTH_SHORT).show()


        }


    }



}
