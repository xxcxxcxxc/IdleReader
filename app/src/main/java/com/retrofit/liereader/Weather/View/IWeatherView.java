package com.retrofit.liereader.Weather.View;

import com.retrofit.liereader.Bean.WeatherBean;


/**
 * Created by xxc on 2018/5/22.
 */

public interface IWeatherView {
    void showWeather(WeatherBean weatherBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(Throwable throwable);
}
