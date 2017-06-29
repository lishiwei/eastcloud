package com.orientalfinance.eastcloud.module.javabean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChannelCategory implements Parcelable {

        @SerializedName("cate_id")
        String cateId;
        @SerializedName("cate_name")
        String cateName;
        List<RecommandCategory> child;

        public List<RecommandCategory> getChild() {
            return child;
        }

        public void setChild(List<RecommandCategory> child) {
            this.child = child;
        }

        public String getCateId() {
            return cateId;
        }

        public void setCateId(String cateId) {
            this.cateId = cateId;
        }

        public String getCateName() {
            return cateName;
        }

        public void setCateName(String cateName) {
            this.cateName = cateName;
        }

        public ChannelCategory(String cateId, String cateName) {
            this.cateId = cateId;
            this.cateName = cateName;
        }

        @Override
        public String toString() {
            return "Catalog{" +
                    "cateId='" + cateId + '\'' +
                    ", cateName='" + cateName + '\'' +
                    '}';
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.cateId);
        dest.writeString(this.cateName);
        dest.writeTypedList(this.child);
    }

    protected ChannelCategory(Parcel in) {
        this.cateId = in.readString();
        this.cateName = in.readString();
        this.child = in.createTypedArrayList(RecommandCategory.CREATOR);
    }

    public static final Parcelable.Creator<ChannelCategory> CREATOR = new Parcelable.Creator<ChannelCategory>() {
        @Override
        public ChannelCategory createFromParcel(Parcel source) {
            return new ChannelCategory(source);
        }

        @Override
        public ChannelCategory[] newArray(int size) {
            return new ChannelCategory[size];
        }
    };
}