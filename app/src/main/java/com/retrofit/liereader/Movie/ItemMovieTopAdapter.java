package com.retrofit.liereader.Movie;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.retrofit.R;
import com.retrofit.liereader.ADetailActivity;
import com.retrofit.liereader.Bean.MoviesBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 18/6/5.
 */

public class ItemMovieTopAdapter extends RecyclerView.Adapter<ItemMovieTopAdapter.ViewHolder> {

    private List<MoviesBean.SubjectsBean> objects = new ArrayList<MoviesBean.SubjectsBean>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemMovieTopAdapter(Context context) {

        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }
    public void setData(List<MoviesBean.SubjectsBean> objects){
        this.objects = objects;
    }
    @Override
    public ItemMovieTopAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie_top, parent, false);
        return new ItemMovieTopAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ItemMovieTopAdapter.ViewHolder holder, int position) {
        final MoviesBean.SubjectsBean bean=objects.get(position);
        if (bean==null){
            return;
        }
        Glide.with(context)
                .load(bean.getImages().getSmall())
                .into(holder.ivMovieTop);
        holder.tvMovieTopTitle.setText(bean.getTitle());
        holder.rlMovieOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ADetailActivity.class);
                intent.putExtra("url",bean.getAlt());
                intent.putExtra("title", bean.getTitle());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout rlMovieOn;
        private ImageView ivMovieTop;
        private TextView tvMovieTopTitle;

        public ViewHolder(View view) {
            super(view);
            rlMovieOn = (LinearLayout) view.findViewById(R.id.rl_movie_on);
            ivMovieTop = (ImageView) view.findViewById(R.id.iv_movie_top);
            tvMovieTopTitle = (TextView) view.findViewById(R.id.tv_movie_top_title);
        }
    }
}