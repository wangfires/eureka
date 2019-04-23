package com.baizhi.action;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Area;
import com.baizhi.entity.City;
import com.baizhi.entity.Province;
import com.baizhi.service.AreaService;
import com.baizhi.service.CityService;
import com.baizhi.service.Impl.AreaServiceImpl;
import com.baizhi.service.Impl.CityServiceImpl;
import com.baizhi.service.Impl.ProvinceServiceImpl;
import com.baizhi.service.ProvinceService;
import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ProvinceAction {
    private String provinceCode;
    private String cityCode;
    private List<Province> provinces;
    private List<City> citys;
    private List<Area> areas;

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    public List<City> getCitys() {
        return citys;
    }

    public void setCitys(List<City> citys) {
        this.citys = citys;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    CityService cs=new CityServiceImpl();
    AreaService as= new AreaServiceImpl();
    ProvinceService ps = new ProvinceServiceImpl();
    public String findProvince() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter writer = response.getWriter();
        provinces=ps.findProvince();
        String province = JSONObject.toJSONString(provinces);
        writer.write(province);
        return Action.NONE;
    }
    public String findCity() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter writer = response.getWriter();
        citys=cs.findCity(provinceCode);
        String city = JSONObject.toJSONString(citys);
        writer.write(city);
        return Action.NONE;
    }
    public String findArea() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter writer = response.getWriter();
        areas=as.findArea(cityCode);
        String area = JSONObject.toJSONString(areas);
        writer.write(area);
        return Action.NONE;
    }
}
