package com.orientalfinance.eastcloud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.mcxtzhang.swipemenulib.SwipeMenuLayout;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.javabean.Collection;
import com.orientalfinance.eastcloud.view.OnSwipeDeleteListener;

import java.util.List;

public class CollectionAdapter extends BaseAdapter {

    private Context context;
    private List<Collection> data;
    private boolean isShow = false;

    public CollectionAdapter(Context context, List<Collection> data) {
        super();
        this.context = context;
        this.data = data;
    }

    public void setData(List<Collection> data) {
        this.data = data;
        notifyDataSetChanged();

    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean isShow) {
        this.isShow = isShow;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
       ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_collection, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Collection tvShowEntity = data.get(position);
        holder.name.setText(tvShowEntity.getChannelName());
        holder.time.setText(tvShowEntity.getProgramTime());
        holder.profile.setText(tvShowEntity.getCurrentProgram());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                data.get(position).setChecked(isChecked);
            }
        });

        final ViewHolder finalHolder = holder;
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getOnSwipeDeleteListener()!=null)
                {
                    getOnSwipeDeleteListener().onDeleteListener(finalHolder.swipeMenuLayout,position);
                }
//                finalHolder.swipeMenuLayout.quickClose();
//                data.remove(position);
//                notifyDataSetChanged();
            }
        });

        if (isShow) {
            holder.checkBox.setVisibility(View.VISIBLE);
        } else {
            holder.checkBox.setVisibility(View.GONE);
        }

        holder.checkBox.setChecked(tvShowEntity.isChecked());

        return convertView;
    }
OnSwipeDeleteListener mOnSwipeDeleteListener;

    public void setOnSwipeDeleteListener(OnSwipeDeleteListener onSwipeDeleteListener) {
        mOnSwipeDeleteListener = onSwipeDeleteListener;
    }

    public OnSwipeDeleteListener getOnSwipeDeleteListener() {
        return mOnSwipeDeleteListener;
    }

    /**
     * ListView中后面的Item划出来时可以从viewholder对象中取出,
     * 不必再去findViewById，降低了查找的时间
     *
     * @author Myron
     */
    public static class ViewHolder {
        TextView name;
        TextView time;
        TextView profile;
        CheckBox checkBox;
        Button button;
        SwipeMenuLayout swipeMenuLayout;

        ViewHolder(View view) {
            name = (TextView) view.findViewById(R.id.tv_tv_show_name);
            time = (TextView) view.findViewById(R.id.tv_tv_show_time);
            profile = (TextView) view.findViewById(R.id.tv_tv_show_profile);
            checkBox = (CheckBox) view.findViewById(R.id.cb_del);
            button = (Button) view.findViewById(R.id.btnDelete);
            swipeMenuLayout = (SwipeMenuLayout) view;
        }
    }
}
