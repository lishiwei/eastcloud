package com.orientalfinance.eastcloud.module.javabean;

/**
 * 类描述：修改头像实体类
 * Created by lzy on 2017/6/10.
 * email:lizy@oriental-finance.com
 */

public class EditHeaderImage {
    // 用户id
    private String id;
    //图像上传后主键
    private String file_id;

    public EditHeaderImage() {
    }

    public EditHeaderImage(String id, String file_id) {
        this.id = id;
        this.file_id = file_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    @Override
    public String toString() {
        return "EditHeaderImage{" +
                "id='" + id + '\'' +
                ", file_id='" + file_id + '\'' +
                '}';
    }
}
