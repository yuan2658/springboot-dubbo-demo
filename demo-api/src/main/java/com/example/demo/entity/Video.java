package com.example.demo.entity;

import java.io.Serializable;

/**
 * (Video)实体类
 *
 * @author makejava
 * @since 2020-02-15 17:33:42
 */
public class Video implements Serializable {
    private static final long serialVersionUID = -66886548814263492L;
    
    private String id;
    
    private String type;
    
    private String url;
    
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
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

}