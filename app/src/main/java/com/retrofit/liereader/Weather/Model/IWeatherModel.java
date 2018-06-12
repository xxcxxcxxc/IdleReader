package com.retrofit.liereader.Weather.Model;


/**
 * Created by xxc on 2018/5/22.
 */

public interface IWeatherModel {
    void loadWeather(Integer citykey, IWeatherLoadListener iWeatherLoadListener);
}
