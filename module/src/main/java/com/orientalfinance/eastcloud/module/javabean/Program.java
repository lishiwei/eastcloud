package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;
import com.orientalfinance.eastcloud.module.Retrofit.ShowRequestParam;

/**
 * Created by 29435 on 2017/6/18.
 */

public class Program {
    @SerializedName("program_id")
    String channelId;
    @SerializedName("program_name")
    String channelName;
    @SerializedName("air_time")
    String playTime;

    public Program(String channelId, String channelName, String playTime) {
        this.channelId = channelId;
        this.channelName = channelName;
        this.playTime = playTime;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    @Override
    public String toString() {
        return "Program{" +
                "channelId='" + channelId + '\'' +
                ", channelName='" + channelName + '\'' +
                ", playTime='" + playTime + '\'' +
                '}';
    }
  public static class CurrentHitRequestParam extends ShowRequestParam{
      String catelog_id;

      public CurrentHitRequestParam(int start, int length, String catelog_id) {
          super(start, length);
          this.catelog_id = catelog_id;
      }

      public String getCatelog_id() {
          return catelog_id;
      }

      public void setCatelog_id(String catelog_id) {
          this.catelog_id = catelog_id;
      }

      @Override
      public String toString() {
          return "CurrentHitRequestParam{" +
                  "catelog_id='" + catelog_id + '\'' +
                  '}';
      }
  }
}
