package com.retrofit.liereader.Weather.Model;

import com.retrofit.liereader.Bean.TodayContentBean;
import com.retrofit.liereader.Bean.VideoUrlBean;
import com.retrofit.liereader.Bean.WeatherBean;

import java.util.List;

/**
 * Created by xxc on 2018/5/22.
 */

public interface IWeatherLoadListener {
    void success(WeatherBean weatherBeans);
    void fail(Throwable throwable);
}
