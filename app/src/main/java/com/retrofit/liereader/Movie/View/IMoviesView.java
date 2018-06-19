package com.retrofit.liereader.Movie.View;

import com.retrofit.liereader.Bean.MoviesBean;

/**
 * Created by xxc on 2018/5/22.
 */

public interface IMoviesView {
    void showMovies(MoviesBean moviesBean);
    void showMoreMovies(MoviesBean moviesBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(Throwable throwable);
}
