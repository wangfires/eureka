package com.baizhi.entity;

public class Area {
    private Integer id;
    private String code;
    private String name;
    private String cityId;

    public Area() {
    }

    public Area(Integer id, String code, String name, String cityId) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.cityId = cityId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", cityId='" + cityId + '\'' +
                '}';
    }
}
