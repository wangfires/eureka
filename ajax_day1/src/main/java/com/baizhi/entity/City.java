package com.baizhi.entity;

public class City {
    private Integer id;
    private String code;
    private String name;
    private String provinceId;

    public City() {
    }

    public City(Integer id, String code, String name, String provinceId) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.provinceId = provinceId;
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

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", provinceId='" + provinceId + '\'' +
                '}';
    }
}
