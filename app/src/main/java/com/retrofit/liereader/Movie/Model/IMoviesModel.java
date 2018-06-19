package com.retrofit.liereader.Movie.Model;



/**
 * Created by xxc on 2018/5/22.
 */

public interface IMoviesModel {
    void loadMovies(String total,
                    int start,
                    IOnLoadListener iOnLoadListener);

}
