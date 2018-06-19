package com.retrofit.liereader.News.Model;

import com.retrofit.liereader.Bean.NewsBean;

/**
 * Created by apple on 18/5/22.
 */

public interface IOnLoadListener {
    void success(NewsBean newsBean);
    void fail(Throwable throwable);

    void loadMoreSuccess(NewsBean newsBean);
}

