package com.retrofit.liereader.News.Model;

import com.retrofit.liereader.News.Model.IOnLoadListener;

/**
 * Created by apple on 18/5/22.
 */

public interface INewsModel {
    void loadNews(String hostType,
                  int startPage,
                  String id,
                  IOnLoadListener iOnLoadListener);
}