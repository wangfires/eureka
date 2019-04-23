package com.baizhi.entity;

public class Files {
    private String id;
    private String oldname;
    private String newname;
    private String suffix;
    private String path;
    private Long size;
    private String type;
    private Integer num;
    private String userid;

    public Files() {
    }

    public Files(String id, String oldname, String newname, String suffix, String path, Long size, String type, Integer num, String userid) {
        this.id = id;
        this.oldname = oldname;
        this.newname = newname;
        this.suffix = suffix;
        this.path = path;
        this.size = size;
        this.type = type;
        this.num = num;
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Files{" +
                "id='" + id + '\'' +
                ", oldname='" + oldname + '\'' +
                ", newname='" + newname + '\'' +
                ", suffix='" + suffix + '\'' +
                ", path='" + path + '\'' +
                ", size=" + size +
                ", type='" + type + '\'' +
                ", num=" + num +
                ", userid='" + userid + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOldname() {
        return oldname;
    }

    public void setOldname(String oldname) {
        this.oldname = oldname;
    }

    public String getNewname() {
        return newname;
    }

    public void setNewname(String newname) {
        this.newname = newname;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
