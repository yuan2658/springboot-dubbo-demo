package com.example.demo.entity;

import com.sun.org.apache.bcel.internal.generic.DMUL;

/**
 * @Description: 类型
 * @Author: yy
 * @Date: Created in 2020/2/15 19:45
 * @Modified By：
 */
public enum VideoType {

    /**
     *  类型
     */

    RH("日韩","rha"),
    DM("动漫","dm"),
    WM("无码","wm"),
    OME("欧美","ome"),
    GCH("国产","gch"),
    LLYP("三级","llyp");

    private String name;
    private String type;


    VideoType(String name, String type) {
        this.name=name;
        this.type=type;
    }

    public static String getName(String type) {
        for (VideoType videoType : VideoType.values()) {
            if (type.equals(videoType.getType())) {
                return videoType.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
