package com.orientalfinance.eastcloud.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orientalfinance.BR;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ItemMytvBinding;
import com.orientalfinance.eastcloud.module.javabean.TV;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class MyTVRvAdpter extends RecyclerView.Adapter<MyTVRvAdpter.MyTVViewHolder> {
    private static final String TAG = MyTVRvAdpter.class.getSimpleName();
    List<TV> mMovieList;

    public List<TV> getMovieList() {
        return mMovieList;
    }

    @Override
    public MyTVViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ItemMytvBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_mytv, null, true);
        final MyTVViewHolder myTVViewHolder = new MyTVViewHolder(viewDataBinding.getRoot());
        myTVViewHolder.setViewDataBinding(viewDataBinding);
//        myTVViewHolder.itemView.findViewById(R.id.tv_connect).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mMovieList.get(myTVViewHolder.getLayoutPosition()).getStatus().equals("在线")) {
//
//                }
//            }
//        });
//        myTVViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), ActivityTopBoxDetail.class);
//                v.getContext().startActivity(intent);
//            }
//        });
        return myTVViewHolder;
    }

    public MyTVRvAdpter(List<TV> movies) {
        mMovieList = movies;
    }

    @Override
    public void onBindViewHolder(MyTVViewHolder holder, int position) {

        holder.mViewDataBinding.setVariable(BR.item, mMovieList.get(position));

    }

    public void setMovieList(List<TV> movieList) {

        mMovieList = movieList;
        notifyDataSetChanged();
    }
    public void removeItem(int position) {
        mMovieList.remove(position);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

   public class MyTVViewHolder extends RecyclerView.ViewHolder {

      public   ItemMytvBinding mViewDataBinding;

       public LinearLayout content;
       public TextView delete;
       public LinearLayout layout;

        public MyTVViewHolder(View itemView) {
            super(itemView);

        }

       public ItemMytvBinding getViewDataBinding() {
           return mViewDataBinding;
       }

       public void setViewDataBinding(ItemMytvBinding viewDataBinding) {
            mViewDataBinding = viewDataBinding;
           content = getViewDataBinding().itemContent;
           delete = getViewDataBinding().itemDelete;
           layout = getViewDataBinding().itemLayout;

        }
    }
}
