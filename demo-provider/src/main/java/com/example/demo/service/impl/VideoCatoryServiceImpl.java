package com.example.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.entity.Video;
import com.example.demo.entity.VideoCatory;
import com.example.demo.dao.VideoCatoryDao;
import com.example.demo.service.VideoCatoryService;
import com.example.demo.service.VideoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * (VideoCatory)表服务实现类
 *
 * @author makejava
 * @since 2020-02-19 23:00:45
 */
@Service
public class VideoCatoryServiceImpl implements VideoCatoryService {
    @Resource
    private VideoCatoryDao videoCatoryDao;

    @Resource
    private VideoService videoService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public VideoCatory queryById(Integer id) {
        return this.videoCatoryDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<VideoCatory> queryAllByLimit(int offset, int limit) {
        return this.videoCatoryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param videoCatory 实例对象
     * @return 实例对象
     */
    @Override
    public VideoCatory insert(VideoCatory videoCatory) {
        this.videoCatoryDao.insert(videoCatory);
        return videoCatory;
    }

    /**
     * 修改数据
     *
     * @param videoCatory 实例对象
     * @return 实例对象
     */
    @Override
    public VideoCatory update(VideoCatory videoCatory) {
        this.videoCatoryDao.update(videoCatory);
        return this.queryById(videoCatory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.videoCatoryDao.deleteById(id) > 0;
    }


    @Override
    public void updates(Integer account){
        List<Video> videos = videoService.queryAllByLimit("0", account, 50);
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
            insert(videoCatory);
            video.setStatus("1");
            videoService.update(video);
        }



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
