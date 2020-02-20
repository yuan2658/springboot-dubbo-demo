package com.example.demo.entity;

import java.io.Serializable;

/**
 * (VideoCatory)实体类
 *
 * @author makejava
 * @since 2020-02-19 23:00:44
 */
public class VideoCatory implements Serializable {
    private static final long serialVersionUID = 193233034185474214L;
    
    private Integer id;
    
    private String type;
    
    private String url;
    
    private String name;
    
    private String tag;
    
    private String year;
    
    private String month;
    
    private String day;
    
    private String source;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}