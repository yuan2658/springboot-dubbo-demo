package com.example.demo.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.VideoType;
import com.example.demo.util.UrlUtils;
import com.example.demo.entity.Video;
import com.example.demo.service.VideoService;
import org.springframework.web.bind.annotation.*;




/**
 * (Video)表控制层
 *
 * @author makejava
 * @since 2020-02-15 17:33:45
 */
@RestController
@RequestMapping("video")
public class VideoController {
    /**
     * 服务对象
     */
    @Reference
    private VideoService videoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Video selectOne(String id) {
        return videoService.queryById(id);
    }


    @GetMapping("save1")
    public String save1() throws Exception {
        //开始时间
        long startTime=System.currentTimeMillis();

        VideoType[] values = VideoType.values();
        for(VideoType videoType:values){
            String data = getData(videoType.getType());
            if(!StringUtils.isBlank(data)){
                videoService.save(data,videoType.getType());
            }else {
                System.out.println("无效数据========="+videoType.getName());
            }
        }
        //结束时间
        long endTime=System.currentTimeMillis();
        System.out.println("save1执行时间为："+(endTime-startTime)/1000 +"s");
        return "200";
    }

    @GetMapping("save2")
    public String save2() throws Exception {
        //开始时间
        long startTime=System.currentTimeMillis();

        VideoType[] values = VideoType.values();
        for(VideoType videoType:values){
            String data = getData(videoType.getType());
            if(!StringUtils.isBlank(data)){
                videoService.save(data,videoType.getType());
            }else {
                System.out.println("无效数据========="+videoType.getName());
            }
        }
        //结束时间
        long endTime=System.currentTimeMillis();
        System.out.println("save2执行时间为："+(endTime-startTime)/1000 +"s");
        return "200";
    }


    @GetMapping("save3")
    public String save3() throws Exception {
        //开始时间
        long startTime=System.currentTimeMillis();

        VideoType[] values = VideoType.values();
        for(VideoType videoType:values){
            String data = getData(videoType.getType());
            if(!StringUtils.isBlank(data)){
                videoService.save(data,videoType.getType());
            }else {
                System.out.println("无效数据========="+videoType.getName());
            }
        }
        //结束时间
        long endTime=System.currentTimeMillis();
        System.out.println("save3执行时间为："+(endTime-startTime)/1000 +"s");
        return "200";
    }


    @GetMapping("save4")
    public String save4() throws Exception {
        //开始时间
        long startTime=System.currentTimeMillis();

        VideoType[] values = VideoType.values();
        for(VideoType videoType:values){
            String data = getData(videoType.getType());
            if(!StringUtils.isBlank(data)){
                videoService.save(data,videoType.getType());
            }else {
                System.out.println("无效数据========="+videoType.getName());
            }
        }
        //结束时间
        long endTime=System.currentTimeMillis();
        System.out.println("save4执行时间为："+(endTime-startTime)/1000 +"s");
        return "200";
    }



    @GetMapping("save5")
    public String save5() throws Exception {
        //开始时间
        long startTime=System.currentTimeMillis();

        VideoType[] values = VideoType.values();
        for(VideoType videoType:values){
            String data = getData(videoType.getType());
            if(!StringUtils.isBlank(data)){
                videoService.save(data,videoType.getType());
            }else {
                System.out.println("无效数据========="+videoType.getName());
            }
        }
        //结束时间
        long endTime=System.currentTimeMillis();
        System.out.println("save5执行时间为："+(endTime-startTime)/1000 +"s");
        return "200";
    }

    public String getData(String type) throws Exception {
        String url = "http://mu.coroad.cn//bf2.php?lx="+ type;
        return UrlUtils.getJsonByUrl(url,"GET");
    }


}
