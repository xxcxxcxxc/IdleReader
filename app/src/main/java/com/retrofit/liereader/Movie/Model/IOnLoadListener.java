package com.retrofit.liereader.Movie.Model;

import com.retrofit.liereader.Bean.MoviesBean;

/**
 * Created by xxc on 2018/5/22.
 */

public interface IOnLoadListener {
    void success(MoviesBean moviesBean);
    void fail(Throwable throwable);

    void loadMoreSuccess(MoviesBean moviesBean);
}
