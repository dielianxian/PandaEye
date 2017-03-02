package com.pandaq.pandaeye.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pandaq.pandaeye.R;
import com.pandaq.pandaeye.entity.neteasynews.TopNews;
import com.pandaq.pandaeye.utils.DensityUtil;
import com.pandaq.pandaqlib.magicrecyclerView.BaseRecyclerAdapter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PandaQ on 2016/9/22.
 * email : 767807368@qq.com
 */

public class TopNewsListAdapter extends BaseRecyclerAdapter<TopNews> {

    private Context mContext;
    private int widthPx;
    private int heighPx;

    public TopNewsListAdapter(Fragment fragment) {
        mContext = fragment.getContext();
        float width = mContext.getResources().getDimension(R.dimen.news_image_width);
        widthPx = (int) width;
        heighPx = widthPx * 3 / 4;
    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.topnews_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBind(RecyclerView.ViewHolder holder, int RealPosition, TopNews data) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).mNewsTitle.setText(data.getTitle());
            ((ViewHolder) holder).mSource.setText(data.getSource());
            String image = data.getImgsrc();
            Picasso.with(mContext)
                    .load(image)
                    .resize(widthPx, heighPx)
                    .into(((ViewHolder) holder).mNewsImage);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.news_image)
        ImageView mNewsImage;
        @BindView(R.id.news_title)
        TextView mNewsTitle;
        @BindView(R.id.source)
        TextView mSource;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
