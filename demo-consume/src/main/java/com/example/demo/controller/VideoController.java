package com.example.demo.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.VideoType;
import com.example.demo.util.UrlUtils;
import com.example.demo.entity.Video;
import com.example.demo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.zookeeper.ZooDefs.OpCode.getData;


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


    @GetMapping("save")
    public String save() throws Exception {
        //开始时间
        long startTime=System.currentTimeMillis();

        VideoType[] values = VideoType.values();
        for(VideoType videoType:values){
            String data = getData(videoType.getType());
            videoService.save(data,videoType.getType());
        }
        //结束时间
        long endTime=System.currentTimeMillis();
        System.out.println("执行时间为："+(endTime-startTime)/1000 +"s");
        return "200";
    }


    public String getData(String type) throws Exception {
        String url = "https://getman.cn/api/request?url=http://mu.coroad.cn//bf2.php?lx="+ type;
        String jsonByUrl = UrlUtils.getJsonByUrl(url,"POST");
        System.out.println(jsonByUrl);
        JSONObject jsonObject = JSONObject.parseObject(jsonByUrl);
        return  (String) jsonObject.get("body");
    }


}
