package com.retrofit.liereader.Video.View;

import com.retrofit.liereader.Bean.MoviesBean;
import com.retrofit.liereader.Bean.TodayContentBean;

import java.util.List;

/**
 * Created by xxc on 2018/5/22.
 */

public interface IVideoView {
    void showVideo(List<TodayContentBean> todayContentBeans,List<String> videoList);
    void hideDialog();
    void showDialog();
    void showErrorMsg(Throwable throwable);
}
