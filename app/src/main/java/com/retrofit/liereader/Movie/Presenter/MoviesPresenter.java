package com.retrofit.liereader.Movie.Presenter;

import com.retrofit.liereader.Bean.MoviesBean;
import com.retrofit.liereader.Movie.Model.IMoviesModel;
import com.retrofit.liereader.Movie.Model.IOnLoadListener;
import com.retrofit.liereader.Movie.Model.MoviesModel;
import com.retrofit.liereader.Movie.View.IMoviesView;

/**
 * Created by xxc on 2018/5/22.
 */

public class MoviesPresenter implements IMoviesPresenter,IOnLoadListener {

    private IMoviesModel iMoviesModel;
    private IMoviesView iMoviesView;

    public MoviesPresenter(IMoviesView iMoviesView){
        this.iMoviesView = iMoviesView;
        this.iMoviesModel = new MoviesModel();
    }

    @Override
    public void success(MoviesBean moviesBean) {
        iMoviesView.hideDialog();
        iMoviesView.showNews(moviesBean);
    }


    @Override
    public void fail(Throwable throwable) {
        iMoviesView.hideDialog();
        iMoviesView.showErrorMsg(throwable);
    }

    @Override
    public void loadNews(String total) {
        iMoviesView.showDialog();
        iMoviesModel.loadNews(total,this);

    }

}
