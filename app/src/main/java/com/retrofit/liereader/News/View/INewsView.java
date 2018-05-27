package com.retrofit.liereader.News.View;


import com.retrofit.liereader.Bean.NewsBean;

/**
 * Created by apple on 18/5/22.
 */

public interface INewsView {
    void showNews(NewsBean newsBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(String error);
}
