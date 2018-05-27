package com.retrofit.liereader.Movie.Model;

import android.util.Log;

import com.retrofit.liereader.Bean.MoviesBean;
import com.retrofit.liereader.Http.Api;
import com.retrofit.liereader.Http.RetrofitHelper;
import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by xxc on 2018/5/22.
 */

public class MoviesModel implements IMoviesModel{

    @Override
    public void loadNews( String total, final IOnLoadListener iOnLoadListener) {
        RetrofitHelper retrofitHelper= new RetrofitHelper(Api.MOVIE_HOST);
        retrofitHelper.getMovies(total).enqueue(new Callback<MoviesBean>() {
            @Override
            public void onResponse(Call<MoviesBean> call, Response<MoviesBean> response) {
                iOnLoadListener.success(response.body());
                Log.i("response", "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<MoviesBean> call, Throwable t) {
                iOnLoadListener.fail(t);
            }
        });
    }
}
