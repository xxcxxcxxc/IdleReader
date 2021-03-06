package com.retrofit.liereader.Movie;

/**
 * Created by apple on 18/5/22.
 */

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.retrofit.R;
import com.retrofit.liereader.Bean.MoviesBean;
import com.retrofit.liereader.Movie.Presenter.MoviesPresenter;
import com.retrofit.liereader.Movie.View.IMoviesView;


/**
 * Created by apple on 18/5/22.
 */
public class FgMovieFragment extends Fragment implements IMoviesView {

    private MoviesPresenter moviesPresenter;
    private String  type;
    private RecyclerView rv_movie_on;
    private RecyclerView rv_movie_top;
    private SwipeRefreshLayout srl_movie;
    private ItemMovieOnAdapter movieOnAdapter;
    private ItemMovieTopAdapter movieTopAdapter;
    private LinearLayoutManager layoutManager;
    private int start = 0;

    private  void loadMore(){
        start += 20;
        moviesPresenter.loadMovies(type,start);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_movie, null);

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moviesPresenter = new MoviesPresenter(this);

        srl_movie = view.findViewById(R.id.srl_movie);
        rv_movie_on = view.findViewById(R.id.rv_movie_on);
        movieOnAdapter = new ItemMovieOnAdapter(getActivity());
        srl_movie.setColorSchemeColors(Color.parseColor("#ffce3d3a"));


        rv_movie_top = view.findViewById(R.id.rv_movie_top);
        movieTopAdapter = new ItemMovieTopAdapter(getActivity());

        moviesPresenter.loadMovies("in_theaters",start);
        moviesPresenter.loadMovies("top250",start);
        srl_movie.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                moviesPresenter.loadMovies("in_theaters",start);
                moviesPresenter.loadMovies("top250",start);
            }
        });


    }

    @Override
    public void showMovies(MoviesBean moviesBean) {
        if (moviesBean.getTotal()==250){
            movieTopAdapter.setData(moviesBean.getSubjects());
            rv_movie_top.setLayoutManager(new LinearLayoutManager(getActivity(),
                    LinearLayoutManager.HORIZONTAL,false));
            rv_movie_top.setHorizontalScrollBarEnabled(true);
            rv_movie_top.setAdapter(movieTopAdapter);
        }else {
            movieOnAdapter.setData(moviesBean.getSubjects());
            rv_movie_on.setLayoutManager(new LinearLayoutManager(getActivity()));
            rv_movie_on.setAdapter(movieOnAdapter);
        }
       /* adapter.setData(newsBeanList);
        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rv_news.setAdapter(adapter);
        tv_news_list.setVisibility(View.GONE);*/



    }
    @Override
    public void showMoreMovies(MoviesBean moviesBean) {
        if (moviesBean.getTotal()==250){
            movieTopAdapter.setData(moviesBean.getSubjects());
            rv_movie_top.setLayoutManager(new LinearLayoutManager(getActivity(),
                    LinearLayoutManager.HORIZONTAL,false));
            rv_movie_top.setHorizontalScrollBarEnabled(true);
            rv_movie_top.setAdapter(movieTopAdapter);
        }else {
            movieOnAdapter.addData(moviesBean.getSubjects());
            rv_movie_on.setLayoutManager(new LinearLayoutManager(getActivity()));
            rv_movie_on.setAdapter(movieOnAdapter);
        }
        movieOnAdapter.notifyDataSetChanged();

    }
    @Override
    public void hideDialog() {
        srl_movie.setRefreshing(false);
    }

    @Override
    public void showDialog() {
        srl_movie.setRefreshing(true);
    }

    @Override
    public void showErrorMsg(Throwable throwable) {
        movieOnAdapter.notifyItemRemoved(movieOnAdapter.getItemCount());
        Toast.makeText(getContext(),"加载出错：" + throwable.getMessage(),Toast.LENGTH_SHORT).show();
    }
}
