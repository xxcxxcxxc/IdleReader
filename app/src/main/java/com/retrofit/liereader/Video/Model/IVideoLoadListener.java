package com.retrofit.liereader.Video.Model;

import com.retrofit.liereader.Bean.MoviesBean;
import com.retrofit.liereader.Bean.TodayContentBean;
import com.retrofit.liereader.Bean.VideoUrlBean;

import java.util.List;

/**
 * Created by xxc on 2018/5/22.
 */

public interface IVideoLoadListener {
    void videoUrlSuccess(List<VideoUrlBean> videoUrlBeans, List<TodayContentBean> contentBeans);
    void fail(Throwable throwable);
}
