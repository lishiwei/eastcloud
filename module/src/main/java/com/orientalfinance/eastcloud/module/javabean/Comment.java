package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;
import com.orientalfinance.eastcloud.module.Retrofit.ShowRequestParam;

/**
 * Created by 29435 on 2017/5/31.
 */

public class Comment {
    @SerializedName("comment_id")
    int id;
    @SerializedName("nick_name")
    String name;
    @SerializedName("avator")
    String avatar;
    @SerializedName("content")
    String content;
    @SerializedName("ctime")
    String time;
    public Comment(int id, String name, String avatar, String content, String time) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.content = content;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
    public static class CommentRequestParam extends ShowRequestParam{
        String channel_id;

        public CommentRequestParam(String start, String length, String channel_id) {
            super(start, length);
            this.channel_id = channel_id;
        }

        public String getChannel_id() {
            return channel_id;
        }

        public void setChannel_id(String channel_id) {
            this.channel_id = channel_id;
        }

        @Override
        public String toString() {
            return "CommentRequestParam{" +
                    "channel_id='" + channel_id + '\'' +
                    '}';
        }
    }
    public static class CommitRequestParam{
        String comment_id;
        String content;
        String program_id;
        String channel_id;

        public String getComment_id() {
            return comment_id;
        }

        public void setComment_id(String comment_id) {
            this.comment_id = comment_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getProgram_id() {
            return program_id;
        }

        public void setProgram_id(String program_id) {
            this.program_id = program_id;
        }

        public String getChannel_id() {
            return channel_id;
        }

        public void setChannel_id(String channel_id) {
            this.channel_id = channel_id;
        }

        @Override
        public String toString() {
            return "CommitRequestParam{" +
                    "comment_id='" + comment_id + '\'' +
                    ", content='" + content + '\'' +
                    ", program_id='" + program_id + '\'' +
                    ", channel_id='" + channel_id + '\'' +
                    '}';
        }

        public CommitRequestParam(String comment_id, String content, String program_id, String channel_id) {
            this.comment_id = comment_id;
            this.content = content;
            this.program_id = program_id;
            this.channel_id = channel_id;
        }
    }
}
