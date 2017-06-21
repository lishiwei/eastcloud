package com.orientalfinance.eastcloud.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.javabean.TVConnectState;

import java.util.List;

/**
 * 类描述：遥控器界面连接机顶盒适配器
 * Created by lzy on 2017/6/20.
 * email:lizy@oriental-finance.com
 */

public class TVConnectAdapter extends RecyclerView.Adapter<TVConnectAdapter.ViewHolder> {
    private List<TVConnectState> mList;
    private Context mCtx;
    private ConnectListener mConnectListener;

    public TVConnectAdapter(Context context, List<TVConnectState> list) {
        this.mCtx = context;
        this.mList = list;
    }

    public void setOnConnectListener(ConnectListener connectListener) {
        this.mConnectListener = connectListener;
    }

    /**
     * 方法描述：更新数据
     */
    public void updateData(List<TVConnectState> list, int position) {
        for (int i = 0; i < list.size(); i++) {
            TVConnectState tvConnectState = list.get(i);
            if (i == position) {
                tvConnectState.setConnection(true);
            } else {
                tvConnectState.setConnection(false);
            }
        }
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.item_connect_state, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        TVConnectState tvConnectState = mList.get(position);
        holder.tvLocation.setText(tvConnectState.getLocation());
        if (tvConnectState.isConnection()) {
            holder.connectImg.setImageResource(R.drawable.tv_connect);
            holder.tvConnectBtn.setBackgroundResource(R.drawable.connect_button_selected);
            holder.tvConnectBtn.setText("已连接");
        } else {
            holder.connectImg.setImageResource(R.drawable.tv_unconntect);
            holder.tvConnectBtn.setBackgroundResource(R.drawable.connect_button_normal);
            holder.tvConnectBtn.setText("连接");
        }
        holder.tvConnectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mConnectListener != null) {
                    mConnectListener.onConnectListener(holder, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView connectImg;
        private final TextView tvLocation;
        private final TextView tvConnectBtn;

        public ViewHolder(View itemView) {
            super(itemView);
            connectImg = (ImageView) itemView.findViewById(R.id.logo);
            tvLocation = (TextView) itemView.findViewById(R.id.tv_location);
            tvConnectBtn = (TextView) itemView.findViewById(R.id.tv_connect_btn);
        }
    }


    public interface ConnectListener {
        void onConnectListener(ViewHolder viewHolder, int position);
    }
}
