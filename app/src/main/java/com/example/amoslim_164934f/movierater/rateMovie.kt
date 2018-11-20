package com.example.amoslim_164934f.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.rate_movie.*

class rateMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rate_movie)

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
    }
    //create back button in action bar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //Create new menu resource file, main.xml
        menuInflater.inflate(R.menu.movieratemenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.miSubmit)
        {

            var Ratemovie = ratestar.onRatingBarChangeListener
            var RateMovieTxt = txtdaterelease.text


            val intent = Intent(this,ViewMovieDetail::class.java)
            intent.getDoubleExtra("movieRateTxt", Ratemovie.toString().toDouble())
            intent.putExtra("movieRate",RateMovieTxt )

            startActivity(intent)
            val actionbar = supportActionBar
            actionbar!!.setDisplayHomeAsUpEnabled(true)
        }
        return super.onOptionsItemSelected(item)
    }

}