package com.orientalfinance.eastcloud.module.javabean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public  class RecommandCategory implements Parcelable {

        @SerializedName("id")
        String cateId;
        @SerializedName("name")
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

        public RecommandCategory(String cateId, String cateName) {
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
            dest.writeList(this.child);
        }

        protected RecommandCategory(Parcel in) {
            this.cateId = in.readString();
            this.cateName = in.readString();
            this.child = new ArrayList<RecommandCategory>();
            in.readList(this.child, RecommandCategory.class.getClassLoader());
        }

        public static final Parcelable.Creator<RecommandCategory> CREATOR = new Parcelable.Creator<RecommandCategory>() {
            @Override
            public RecommandCategory createFromParcel(Parcel source) {
                return new RecommandCategory(source);
            }

            @Override
            public RecommandCategory[] newArray(int size) {
                return new RecommandCategory[size];
            }
        };
    }  