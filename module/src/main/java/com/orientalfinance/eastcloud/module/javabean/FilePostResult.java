package com.orientalfinance.eastcloud.module.javabean;

/**
 * 类描述：头像上传响应实体类
 * Created by lzy on 2017/6/10.
 * email:lizy@oriental-finance.com
 */

public class FilePostResult {
    private String id;
    private String file_name;
    private String file_type;
    private String file_url;
    private String file_size;
    private String create_time;
    private String file_mime;
    private String thumbKey;
    private int height;
    private int width;
    private String realPath;
    private String signUrl;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getFile_size() {
        return file_size;
    }

    public void setFile_size(String file_size) {
        this.file_size = file_size;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getFile_mime() {
        return file_mime;
    }

    public void setFile_mime(String file_mime) {
        this.file_mime = file_mime;
    }

    public String getThumbKey() {
        return thumbKey;
    }

    public void setThumbKey(String thumbKey) {
        this.thumbKey = thumbKey;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getRealPath() {
        return realPath;
    }

    public void setRealPath(String realPath) {
        this.realPath = realPath;
    }

    public String getSignUrl() {
        return signUrl;
    }

    public void setSignUrl(String signUrl) {
        this.signUrl = signUrl;
    }

    @Override
    public String toString() {
        return "FilePostResult{" +
                "id=" + id +
                ", file_name='" + file_name + '\'' +
                ", file_type='" + file_type + '\'' +
                ", file_url='" + file_url + '\'' +
                ", file_size='" + file_size + '\'' +
                ", create_time='" + create_time + '\'' +
                ", file_mime='" + file_mime + '\'' +
                ", thumbKey='" + thumbKey + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", realPath='" + realPath + '\'' +
                ", signUrl='" + signUrl + '\'' +
                '}';
    }
}
