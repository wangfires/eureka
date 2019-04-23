package com.baizhi.entity;

public class Comments {
    private String id;
    private String matters;
    private Integer count;
    private String userId;

    public Comments() {
    }

    public Comments(String id, String matters, Integer count, String userId) {
        this.id = id;
        this.matters = matters;
        this.count = count;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatters() {
        return matters;
    }

    public void setMatters(String matters) {
        this.matters = matters;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id='" + id + '\'' +
                ", matters='" + matters + '\'' +
                ", count=" + count +
                ", userId='" + userId + '\'' +
                '}';
    }
}
