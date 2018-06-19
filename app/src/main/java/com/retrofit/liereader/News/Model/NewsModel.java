package com.retrofit.liereader.News.Model;

import com.retrofit.liereader.Bean.NewsBean;
import com.retrofit.liereader.Http.Api;
import com.retrofit.liereader.Http.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by apple on 18/5/22.
 */

public class NewsModel implements INewsModel {

    @Override
    public void loadNews(final String hostType, final int startPage, final String id,
                         final IOnLoadListener iOnLoadListener) {
        RetrofitHelper retrofitHelper= new RetrofitHelper(Api.NEWS_HOST);
        retrofitHelper.getNews(hostType,id,startPage)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<NewsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iOnLoadListener.fail(e);

                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        if (startPage != 0){
                            iOnLoadListener.loadMoreSuccess(newsBean);
                        }else{
                            iOnLoadListener.success(newsBean);
                        }

            }
        });
    }
}
