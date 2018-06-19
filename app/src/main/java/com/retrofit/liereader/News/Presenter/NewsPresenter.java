package com.retrofit.liereader.News.Presenter;

import com.retrofit.liereader.Bean.NewsBean;
import com.retrofit.liereader.Http.Api;
import com.retrofit.liereader.News.FgNewsFragment;
import com.retrofit.liereader.News.Model.INewsModel;
import com.retrofit.liereader.News.Model.IOnLoadListener;
import com.retrofit.liereader.News.Model.NewsModel;
import com.retrofit.liereader.News.View.INewsView;


/**
 * Created by apple on 18/5/22.
 */

public class NewsPresenter implements INewsPresenter,IOnLoadListener {

    private INewsModel iNewsModel;
    private INewsView iNewsView;

    public NewsPresenter(INewsView iNewsView) {
        this.iNewsView = iNewsView;
        this.iNewsModel =new NewsModel();
    }

    @Override
    public void loadNews(int type, int startPage) {
        if (startPage == 0){
            iNewsView.showDialog();
        }

        switch (type){
            case FgNewsFragment.NEWS_TYPE_TOP:
                iNewsModel.loadNews("headline",startPage, Api.HEADLINE_ID,
                        this);
                break;
            case FgNewsFragment.NEWS_TYPE_NBA:
                iNewsModel.loadNews("list",startPage, Api.NBA_ID,
                        this);
                break;
            case FgNewsFragment.NEWS_TYPE_JOKES:
                iNewsModel.loadNews("list",startPage, Api.JOKE_ID,
                        this);
                break;
        }

    }
    @Override
    public void success(NewsBean newsBean) {
        iNewsView.hideDialog();
        if (newsBean!=null){
            iNewsView.showNews(newsBean);
        }

    }

    @Override
    public void fail(Throwable throwable) {
        iNewsView.hideDialog();
        iNewsView.showErrorMsg(throwable);
    }

    @Override
    public void loadMoreSuccess(NewsBean newsBean) {
        iNewsView.hideDialog();
        iNewsView.showMoreNews(newsBean);
    }


}
