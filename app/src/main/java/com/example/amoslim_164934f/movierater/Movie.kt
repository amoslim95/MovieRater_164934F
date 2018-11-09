package com.example.amoslim_164934f.movierater

/**
 *  Created by Amos Lim 164934F
 */


class MovieDetails (movieTitle : String, movieDescription: String,releaseDate: String, movieLanguage: Boolean )
{

    var movieTitle : String
    var movieDescription :String
    var releaseDate: String
    var movieLanguage: Boolean



   init {
        this.movieTitle = movieTitle
        this.movieDescription = movieDescription
        this.releaseDate = releaseDate
        this.movieLanguage = movieLanguage



    }
}
