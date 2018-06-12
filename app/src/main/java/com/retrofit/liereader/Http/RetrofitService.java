package com.retrofit.liereader.Http;


import com.retrofit.liereader.Bean.MoviesBean;
import com.retrofit.liereader.Bean.NewsBean;
import com.retrofit.liereader.Bean.TodayBean;
import com.retrofit.liereader.Bean.VideoUrlBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by apple on 18/5/22.
 */

public interface RetrofitService {
    /*
    * http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html
    * */
    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<NewsBean> getNews(@Path("type") String type,
                                 @Path("id") String id,
                                 @Path("startPage") int startPage);

    @GET("/v2/movie/{total}")
    Observable<MoviesBean> getMovie(@Path("total") String total);
    /*
     http://is.snssdk.com/api/news/feed/v51/?category=video
    */
    @GET("news/feed/v51")
    Observable<TodayBean> getToday(@Query("category") String category);

     /*
     http://ib.365yg.com/video/urls/v/1/toutiao/mp4/v02004f00000bbpbk3l2v325q7lmkds0?r=6781281688452415&s=2734808831
     */

    @GET
    Observable<VideoUrlBean> getVideoUrl(@Url String url);
}
