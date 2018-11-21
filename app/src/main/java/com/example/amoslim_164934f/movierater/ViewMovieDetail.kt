package com.example.amoslim_164934f.movierater

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.view_movie_details.*


class ViewMovieDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_movie_details)

        val movieTitle = intent.getStringExtra("movieTitle")
        val movieDescription = intent.getStringExtra("movieDescription")
        val releaseDate = intent.getStringExtra("releaseDate")
        val movieLanguage = intent.getStringExtra("movieLanguage")
        val notSuitable = intent.getStringExtra("notSuitable")
        val movieViolence = intent.getStringExtra("movieViolence")
        val movieLaugUser = intent.getStringExtra("movieLaugUser")

        val movieRating = intent.getFloatExtra("movieRating",0.0f)

        val newMovie = Movie(movieTitle, movieDescription, releaseDate, movieLanguage, notSuitable, movieViolence, movieLaugUser, movieRating )

        NameText.setText(newMovie.movieTitle)
        ovtext.setText(newMovie.movieDescription)
        langtxt.setText(newMovie.movieLanguage)

        DateText.setText(newMovie.releaseDate)

        suitabletxt.setText(newMovie.notSuitable)
        viotxt.setText(newMovie.movieViolence)
        lantxt.setText(newMovie.movieLaugUser)

        ratestar.setRating(newMovie.movieRating)

        registerForContextMenu(txtMovieReview)

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        val intent = Intent(this, LandingPage::class.java)
        startActivity(intent)
        finish()
    }

    // - onCreateContextMenu
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if (v?.id == R.id.txtMovieReview)
            menu?.add(1, 1001, 1, "Add Review")
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        //note Item ID is used to identify the menu item being selected by user
        if (item?.itemId == 1001) {

            val intent = Intent(this, rateMovie::class.java)
            startActivity(intent)

        }
        return super.onContextItemSelected(item)
    }

}