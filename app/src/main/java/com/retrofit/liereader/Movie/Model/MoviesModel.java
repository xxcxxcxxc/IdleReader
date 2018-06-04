package com.retrofit.liereader.Movie.Model;

import android.util.Log;

import com.retrofit.liereader.Bean.MoviesBean;
import com.retrofit.liereader.Http.Api;
import com.retrofit.liereader.Http.RetrofitHelper;
import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xxc on 2018/5/22.
 */

public class MoviesModel implements IMoviesModel{

    @Override
    public void loadNews( String total, final IOnLoadListener iOnLoadListener) {
        RetrofitHelper retrofitHelper= new RetrofitHelper(Api.MOVIE_HOST);
        retrofitHelper.getMovies(total).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<MoviesBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iOnLoadListener.fail(e);
                    }

                    @Override
                    public void onNext(MoviesBean moviesBean) {
                        iOnLoadListener.success(moviesBean);
                    }
                });
    }
}
