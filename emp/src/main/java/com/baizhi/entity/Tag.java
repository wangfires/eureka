package com.baizhi.entity;

public class Tag {
    private String id;
    private String name;
    private Integer count;

    public Tag() {
    }

    public Tag(String id, String name, Integer count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
