package com.orientalfinance.eastcloud.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.activity.ActivityEditAddress;
import com.orientalfinance.eastcloud.module.javabean.Address;

import java.util.List;

/**
 * Created by lzy on 2017/6/12.
 * email:lizy@oriental-finance.com
 */

public class ManagerAddressAdapter extends BaseAdapter {
    private Context mContext;
    private List<Address> mList;
    private final LayoutInflater layoutInflater;

    public ManagerAddressAdapter(Context context, List<Address> list) {
        this.mContext = context;
        this.mList = list;

        layoutInflater = LayoutInflater.from(mContext);
    }

    public void setList(List<Address> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.lv_address_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();


        final Address address = mList.get(position);
        viewHolder.tvUserName.setText(address.getUserName());
        viewHolder.tvPhone.setText(address.getUserPhone());
        viewHolder.tvAddress.setText(address.getAddress());

        viewHolder.cbSettingAddress.setBackground(convertView.getResources().getDrawable(R.drawable.ic_uncheck));
        viewHolder.cbSettingAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mList.get(position).isDefault()==0)
                {

                }else {
                    if (getOnItemCheckedListener() != null) {
                        getOnItemCheckedListener().OnItemChecked(position);
                    }
                }

            }
        });
        if (mList.get(position).isDefault()==0)
        {
            viewHolder.cbSettingAddress.setBackground(convertView.getResources().getDrawable(R.drawable.check_bg));
            viewHolder.tvDefaultAddress.setTextColor(Color.RED);
        }
        else {
            viewHolder.cbSettingAddress.setBackground(convertView.getResources().getDrawable(R.drawable.ic_uncheck));
            viewHolder.tvDefaultAddress.setTextColor(Color.GRAY);

        }
        viewHolder.ivDeleteAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getOnItemDeleteListener() != null) {
                    getOnItemDeleteListener().onItemDelete(position);
                }
            }
        });
        viewHolder.ivEditAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(), ActivityEditAddress.class);
                intent.putExtra("address", address);
                parent.getContext().startActivity(intent);
            }
        });

        return convertView;
    }

    OnItemCheckedListener mOnItemCheckedListener;

    public void setOnItemCheckedListener(OnItemCheckedListener onItemCheckedListener) {
        mOnItemCheckedListener = onItemCheckedListener;
    }

    public OnItemCheckedListener getOnItemCheckedListener() {
        return mOnItemCheckedListener;
    }

    public static class ViewHolder {

        private ImageView cbSettingAddress;
        private final ImageView ivDeleteAddress;
        private final ImageView ivEditAddress;
        private final TextView tvUserName;
        private final TextView tvAddress;
        private final TextView tvDefaultAddress;
        private final TextView tvPhone;

        public ViewHolder(View view) {
            tvUserName = (TextView) view.findViewById(R.id.tv_user_name);
            tvPhone = (TextView) view.findViewById(R.id.tv_user_phone);
            tvAddress = (TextView) view.findViewById(R.id.tv_address);
            tvDefaultAddress = (TextView) view.findViewById(R.id.tv_defaultAddress);

            cbSettingAddress = (ImageView) view.findViewById(R.id.cb_setting_address);
            ivDeleteAddress = (ImageView) view.findViewById(R.id.iv_delete_address);
            ivEditAddress = (ImageView) view.findViewById(R.id.iv_edit_address);
        }
    }

    OnItemDeleteListener mOnItemDeleteListener;

    public void setOnItemDeleteListener(OnItemDeleteListener onItemDeleteListener) {
        mOnItemDeleteListener = onItemDeleteListener;
    }

    public OnItemDeleteListener getOnItemDeleteListener() {
        return mOnItemDeleteListener;
    }

    public interface OnItemDeleteListener {
        public void onItemDelete(int position);
    }

    public interface OnItemCheckedListener {
        public void OnItemChecked(int position);
    }
}
