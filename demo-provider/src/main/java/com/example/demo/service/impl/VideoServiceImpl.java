package com.example.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.entity.Video;
import com.example.demo.dao.VideoDao;
import com.example.demo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (Video)表服务实现类
 *
 * @author makejava
 * @since 2020-02-15 17:33:45
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    private static Pattern PATTERN_NAME = Pattern.compile("<h1 align='center'>.*?</h1>");
    private static Pattern PATTERN_URL = Pattern.compile("url: '.*?',");


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Video queryById(String id) {
        return this.videoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Video> queryAllByLimit(int offset, int limit) {
        return this.videoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param video 实例对象
     * @return 实例对象
     */
    @Override
    public Video insert(Video video) {
        this.videoDao.insert(video);
        return video;
    }

    /**
     * 修改数据
     *
     * @param video 实例对象
     * @return 实例对象
     */
    @Override
    public Video update(Video video) {
        this.videoDao.update(video);
        return this.queryById(video.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.videoDao.deleteById(id) > 0;
    }


    @Override
    public Video save(String body,String tag){
        Video video = new Video();
        Matcher matcher = PATTERN_NAME.matcher(body);
        int i =0;
        while (matcher.find()) {
            String group = matcher.group(0);
            if(i==0){
                String substring = group.substring(group.indexOf("[") + 1, group.indexOf("]"));
                System.out.println(substring);
                video.setType(substring);
            }else if(i==1){
                String substring = group.substring(group.indexOf("视频名称:") + 5, group.indexOf("</h1>"));
                System.out.println(substring);
                video.setName(substring);
            }
            i++;
        }
        Matcher matcher1 = PATTERN_URL.matcher(body);
        while (matcher1.find()){
            String group = matcher1.group(0);
            String substring = group.substring(group.indexOf("'") + 1, group.lastIndexOf("'"));
            System.out.println(substring);
            video.setUrl(substring);
        }
        video.setTag(tag);
        return insert(video);
    }

}
