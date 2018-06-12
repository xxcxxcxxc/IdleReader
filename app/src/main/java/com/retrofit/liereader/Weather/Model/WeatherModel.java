package com.retrofit.liereader.Weather.Model;

import com.retrofit.liereader.Bean.WeatherBean;
import com.retrofit.liereader.Http.Api;
import com.retrofit.liereader.Http.RetrofitHelper;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xxc on 2018/5/22.
 */

public class WeatherModel implements IWeatherModel {

    @Override
    public void loadWeather(Integer citykey, final IWeatherLoadListener iWeatherLoadListener) {
        final RetrofitHelper retrofitHelper = new RetrofitHelper(Api.WEATHER_HOST);

        retrofitHelper.getWeather(citykey)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<WeatherBean>() {

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        iWeatherLoadListener.fail(e);
                    }

                    @Override
                    public void onNext(WeatherBean weatherBean) {
                        iWeatherLoadListener.success(weatherBean);
                    }
                });
    }

}
