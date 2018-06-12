package com.retrofit.liereader.Weather.Presenter;


import com.retrofit.liereader.Bean.WeatherBean;
import com.retrofit.liereader.Weather.Model.IWeatherLoadListener;
import com.retrofit.liereader.Weather.Model.IWeatherModel;
import com.retrofit.liereader.Weather.Model.WeatherModel;
import com.retrofit.liereader.Weather.View.IWeatherView;

/**
 * Created by xxc on 2018/5/22.
 */

public class WeatherPresenter implements IWeatherPresenter,IWeatherLoadListener{
    private IWeatherModel iWeatherModel;
    private IWeatherView iWeatherView;

    public WeatherPresenter(IWeatherView iWeatherView){
        this.iWeatherView = iWeatherView;
        this.iWeatherModel = new WeatherModel();
    }

    @Override
    public void loadWeather(Integer citykey) {
        iWeatherView.showDialog();
        iWeatherModel.loadWeather(citykey,this);
    }

    @Override
    public void success(WeatherBean weatherBean) {
        iWeatherView.hideDialog();
        if (weatherBean != null){
            iWeatherView.showWeather(weatherBean);
        }
    }

    @Override
    public void fail(Throwable throwable) {
        iWeatherView.hideDialog();
        iWeatherView.showErrorMsg(throwable);

    }
}