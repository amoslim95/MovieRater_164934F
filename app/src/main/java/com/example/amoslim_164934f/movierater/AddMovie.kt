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

    fun onMyBtnClick(v: View){


        var titlename = txtname.text.toString()
        var desc = txtdesc.text.toString()
        var resdate = txtdaterelease.text.toString()
        var laugauge = ""
        var audichecked =""
        var reason = ""


        if (rbtneng.isChecked == true) {
            laugauge = "English"
        }
        else if (rbtnchi.isChecked == true){
            laugauge = "Chinese"
        }
        else if (rbtnmalay.isChecked == true){
            laugauge = "Malay"
        }
        else if (rbtntamil.isChecked == true){
            laugauge = "Tamil"
        }else
            laugauge = "null"


        if (chbaudi.isChecked == false) {
            audichecked = "true"
        }
        else {
            audichecked = "false"
        }


        if(chb3lang.isChecked == true)
        {
            reason="Langauge"
        }
        else
        {
            reason=""
        }


        if (chb2vio.isChecked == true)
        {
            reason="Violence"
        }
        else
            reason =""




        Toast.makeText(getApplicationContext(), "Title = ${titlename}"
                + "\n" + "Overview = ${desc}"
                + "\n" + "Release date = ${resdate}"
                + "\n" + "Lauguage = ${laugauge}"
                + "\n" + "Suitable for ages = ${audichecked}"
                + "\n" + "Reason: ${reason}"

            ,Toast.LENGTH_SHORT).show()

    }
}
