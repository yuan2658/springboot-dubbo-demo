package com.example.demo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.entity.Video;
import com.example.demo.entity.VideoCatory;
import com.example.demo.service.VideoCatoryService;
import com.example.demo.service.VideoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (VideoCatory)表控制层
 *
 * @author makejava
 * @since 2020-02-19 23:00:45
 */
@RestController
@RequestMapping("videoCatory")
public class VideoCatoryController {
    /**
     * 服务对象
     */
    @Reference
    private VideoCatoryService videoCatoryService;
    @Reference
    private VideoService videoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public VideoCatory selectOne(Integer id) {
        return this.videoCatoryService.queryById(id);
    }


    @GetMapping("update1")
    public String update1(){
        List<Video> videos = videoService.queryAllByLimit("0", 1, 50);
        for(Video video : videos){
            VideoCatory videoCatory = new VideoCatory();
            videoCatory.setName(video.getName());
            videoCatory.setTag(video.getTag());
            videoCatory.setType(video.getType());
            String url = video.getUrl();
            videoCatory.setUrl(url);
            videoCatory.setSource(getSource(url));
            videoCatory.setYear(getYears(url));
            videoCatory.setMonth(getMonth(url));
            videoCatory.setDay(getDay(url));
            videoCatoryService.insert(videoCatory);
            video.setStatus("1");
            videoService.update(video);
        }
        return "200";
    }


    @GetMapping("update2")
    public String update2(){
        List<Video> videos = videoService.queryAllByLimit("0", 1, 50);
        for(Video video : videos){
            VideoCatory videoCatory = new VideoCatory();
            videoCatory.setName(video.getName());
            videoCatory.setTag(video.getTag());
            videoCatory.setType(video.getType());
            String url = video.getUrl();
            videoCatory.setUrl(url);
            videoCatory.setSource(getSource(url));
            videoCatory.setYear(getYears(url));
            videoCatory.setMonth(getMonth(url));
            videoCatory.setDay(getDay(url));
            videoCatoryService.insert(videoCatory);
            video.setStatus("1");
            videoService.update(video);
        }
        return "200";
    }


    @GetMapping("update3")
    public String update3(){
        List<Video> videos = videoService.queryAllByLimit("0", 1, 50);
        for(Video video : videos){
            VideoCatory videoCatory = new VideoCatory();
            videoCatory.setName(video.getName());
            videoCatory.setTag(video.getTag());
            videoCatory.setType(video.getType());
            String url = video.getUrl();
            videoCatory.setUrl(url);
            videoCatory.setSource(getSource(url));
            videoCatory.setYear(getYears(url));
            videoCatory.setMonth(getMonth(url));
            videoCatory.setDay(getDay(url));
            videoCatoryService.insert(videoCatory);
            video.setStatus("1");
            videoService.update(video);
        }
        return "200";
    }

    @GetMapping("update4")
    public String update4(){
        List<Video> videos = videoService.queryAllByLimit("0", 1, 50);
        for(Video video : videos){
            VideoCatory videoCatory = new VideoCatory();
            videoCatory.setName(video.getName());
            videoCatory.setTag(video.getTag());
            videoCatory.setType(video.getType());
            String url = video.getUrl();
            videoCatory.setUrl(url);
            videoCatory.setSource(getSource(url));
            videoCatory.setYear(getYears(url));
            videoCatory.setMonth(getMonth(url));
            videoCatory.setDay(getDay(url));
            videoCatoryService.insert(videoCatory);
            video.setStatus("1");
            videoService.update(video);
        }
        return "200";
    }




    public String getYears(String url){
        int i = url.indexOf("com/");

        String substring = url.substring(i+4,i+8);
        return substring;
    }
    public String getMonth(String url){
        int i = url.indexOf("com/");
        String substring = url.substring(i+8,i+10);
        return substring;
    }
    public String getDay(String url){
        int i = url.indexOf("com/");
        String substring = url.substring(i+10,i+12);
        return substring;
    }


    public String getSource(String url){
        String souce = "";
        if(url.indexOf("qiezi")>0){
            souce = "qiezi";
        }else if (url.indexOf("lajiao")>0){
            souce = "lajiao";
        }
        return souce;
    }

}
